package main.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import main.pojo.RegisterUploadInfo;
import main.pojo.ReturnBean;
import main.pojo.enums.CMDType;
import main.pojo.enums.VendorID;
import main.util.DateUtil;
import main.util.X;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @Authuor Administrator
 * @Create 2016-10-28-13:21
 */
public class ClientTask {
    private static final Logger LOG = LogManager.getLogger(ClientTask.class);
    private Channel channel;

    public ClientTask(Channel channel) {
        this.channel = channel;
    }

    public void commitRequest_106(final Object msg){
        try {
            Map<Integer , Object> outContents = new HashMap<>();
            //输出签到信息
            outContents.clear();
            outContents= new HashMap<>();
            RegisterUploadInfo registerInfo = new RegisterUploadInfo();
            registerInfo.setUserID((short) VendorID.FEIHONG.getVenderId());

            //将object序列化为byte[]
            //byte[] serialize = Serializer.serialize(registerInfo);
//            byte[] serialize = new byte[90];
//
//            byte[] bytes = LittleEndianDataConvert.shortToLittleEndianBytesByLength((short)111);
//            System.arraycopy(bytes,0 ,serialize,0,bytes.length);
            registerInfo.setPileType((byte)VendorID.FEIHONG.getVenderId());
            registerInfo.setPileCode("00750014630023");
            registerInfo.setVersion("1.0.0");
            registerInfo.setPileProjectType("feihong");
            registerInfo.setStartTimes(10);
            registerInfo.setUploadMode((byte) 1);
            registerInfo.setIntervalTime((short)10);
            registerInfo.setGunNum((byte)2);
            registerInfo.setIntervalHeartbeat((byte) 10);
            registerInfo.setHeartbeatCheckTimes((short) 2);
            registerInfo.setPileRecordNum(1);
            registerInfo.setPileCurTimes(DateUtil.getCurDate());
            registerInfo.setLastChargingTime(DateUtil.getCurDate());
            registerInfo.setLastStartTime(DateUtil.getCurDate());
            registerInfo.setRegisterPassword("hello123");
            registerInfo.setPileLocalIMEIOrMAC("3c:12:f5:6c");
            outContents.put(CMDType.REGISTER_INFO.getCmdNum() ,registerInfo);
            ReturnBean bean = buildReturnBean(registerInfo);
            ChannelFuture future = channel.writeAndFlush(bean);
            if (future.isSuccess()) {
                LOG.debug("output put data successful =======");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ReturnBean buildReturnBean(RegisterUploadInfo registerUploadInfo) {

        ReturnBean reBean = new ReturnBean();

        Map<Integer, Object> map = X.createMap();
        map.put(CMDType.REGISTER_INFO.getCmdNum(), registerUploadInfo);

        reBean.setReturnMap(map);
        reBean.setPileInfo(registerUploadInfo);
        reBean.setVendorID(VendorID.FEIHONG);
        return reBean;
    }
}
