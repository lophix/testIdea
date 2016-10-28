package main.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import main.output.IOutputDataPackage;
import main.output.OutputDataPackageFactory;
import main.pojo.DataPackageInfo;
import main.pojo.ReturnBean;
import main.pojo.enums.CMDType;
import main.pojo.enums.ChannelAttrEnums;
import main.pojo.enums.VendorID;
import main.util.IntNumDataTypeCodec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Authuor Administrator
 * @Create 2016-10-28-12:47
 */
public class DataPacketEncoder extends MessageToByteEncoder<ReturnBean> {
    private static final Logger LOGGER = LogManager.getLogger(DataPacketEncoder.class);
    private static final int DELAY = 8;
    private final AtomicInteger runCount = new AtomicInteger();
    private final int maxRunCount = 3;


    /**
     *重写了MessageToByteEncoder的发送方法，实现对出站数据的重发要求
     *注：写出方法必须是super.write()方法,一边调用encoder()实现对数据的编码
     */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        //设计重发机制
//        ReturnBean bean  = (ReturnBean) msg;
//        //获取到需要进行重新发送的指令
//        List<Map.Entry<Integer, Object>> collect = bean.getReturnMap().entrySet().stream()
//                .filter(entry -> entry != null && CMDType.getCMDTypeByCMDId(entry.getKey()).getResendTimes() != null).collect(Collectors.toList());
//
//        boolean b = collect.size() > 0;
//        if(b){
//            //需要重发的指令
//            collect.forEach(entry -> {
//                LOGGER.info("will process the resend CMD {} ,process class is {} ",entry.getKey(), entry.getValue().getClass().getName());
//                try {
//                    ScheduledFuture<?> schedule = ctx.executor().schedule(() -> {
//                        try {
//                            if (! promise.isDone()) {
//                                super.write(ctx, msg, promise);
//                            }
//                            if ((runCount.incrementAndGet() > maxRunCount)) {
//                               //抛出异常来结束当前的线程
//                                throw new RuntimeException("execute times out ");
//                            }
//                        } catch (Exception e) {
//                            LOGGER.error("failed to schedule executed the resend task {} ,", e.getMessage());
//                            ctx.fireExceptionCaught(e.getCause());
//                        }
//                    }, DELAY, TimeUnit.SECONDS);
//
//                    //获取其发送是否成功
//                    promise.addListener(new ChannelFutureListener() {
//                        @Override
//                        public void operationComplete(ChannelFuture future) throws Exception {
//                            if (future.isDone()) {
//                                LOGGER.info("send data is successful ..., will close the resend task schedule");
//                                schedule.cancel(false);
//                            }else {
//                                LOGGER.error("send data status is {} ",future.isDone());
//                            }
//                        }
//                    });
//                    super.write(ctx,msg,promise);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    LOGGER.error(e.getMessage());
//                }
//            });
//        }else{
//            //不需要重发的指令, 调用该方法的父类的方法,调用encode()
//            super.write(ctx, msg, promise);
//        }
        super.write(ctx, msg, promise);
    }



    @Override
    protected void encode(ChannelHandlerContext ctx, ReturnBean outObj, ByteBuf out) throws Exception {
        try {
            conductEncode(ctx.channel() ,outObj, out);
        } catch (Exception e) {
            LOGGER.error("encode the outPut data error {}", e);
        }
    }

    /**
     * 编码的实现类
     */
    protected void conductEncode(Channel channel, ReturnBean msg, ByteBuf out) throws Exception {
        LOGGER.debug("the output data size is :{} ", msg.getReturnMap().size());

        Iterator<Map.Entry<Integer, Object>> iter = msg.getReturnMap().entrySet().iterator();

        CMDType cmdType = null;
        if (iter.hasNext()) {
            Map.Entry<Integer, Object> next = iter.next();
            cmdType = CMDType.getCMDTypeByCMDId(next.getKey());
            //不等于空才能继续
            assert cmdType != null;

            //将对象转换为对应的类
            IOutputDataPackage outputDataRectifier = OutputDataPackageFactory.getOutputDataRectifierByCMDType(cmdType);
            byte[] domainDataBytes = outputDataRectifier.outputDataRectify(cmdType, next.getValue());
            //读取returnBean中的序列号域，默认值为0x1
            byte serialId = (byte) (runCount.getAndIncrement()%Byte.MAX_VALUE);
            //写入通用数据
            VendorID vendorID = channel.attr(ChannelAttrEnums.CHANNEL_ATTR_VENDOR_ID).get();
            outBufPreProcess(out, vendorID,serialId,domainDataBytes.length + 9, cmdType.getCmdNum());
            //吸入数据域
            out.writeBytes(domainDataBytes);
            //写入校验域
            out.writeByte(getCheckArea(cmdType.getCmdNum(), domainDataBytes));
            LOGGER.info("write msg successful CMD is :{}" ,cmdType.getCmdNum());
        } else {
            LOGGER.warn(" the output put obj is empty, cmd is {} ");
        }
    }

    /**
     * 写入通用数据
     *
     * @param out             输出buf
     * @param venderID        厂商起始域
     * @param totalDataLength 该数据的总长度
     * @param CMD             命令代码
     */
    private void outBufPreProcess(ByteBuf out, VendorID venderID,byte serialId, int totalDataLength, int CMD) {

        //1. 写入头数据 2 byte
        byte[] startDomain = DataPackageInfo.getStartDomainByVenderId(venderID);
        out.writeBytes(startDomain);

        //2. 写入长度数据 2 byte
        byte[] bytes1 = DataPackageInfo.buildLengthDomain(totalDataLength);
        out.writeBytes(bytes1);

        //3.写入版本域数据 1byte
        byte[] bytes3 = DataPackageInfo.getVersionDomain();
        out.writeBytes(bytes3);

        //4. 序号 1byte
        //int NO = 0x1;
        //modify by qudong-2016-02-29
        int NO = serialId;
        byte[] bytes4 = DataPackageInfo.buildIndexDomain(NO);
        out.writeBytes(bytes4);

        //5. 写 命令代码 2byte
        byte[] bytes5 = DataPackageInfo.buildCMDDomain(CMD);
//        LOGGER.debug("命令代码  {} ,  {} ", bytes5.length, Arrays.toString(bytes5));
        out.writeBytes(bytes5);
    }

    /**
     * 生成校验和域
     * todo:使用算法完善
     */
    private byte getCheckArea(int cmdCode, byte[] domainData) {
        int checkValue = 0;
        byte[] bytes = IntNumDataTypeCodec.encodeIntDataToHexBytes(cmdCode, 2);
        for (int i = 0; i < bytes.length; i++) {
            checkValue += bytes[i] & 0xFF;
        }
        for (int i = 0; i < domainData.length; i++) {
            checkValue += domainData[i] & 0xFF;
        }
        checkValue = checkValue % 256;
        LOGGER.debug("this check sum is {}", checkValue);
        return (byte) checkValue;
    }
}
