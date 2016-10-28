package main.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import main.pojo.RegisterUploadInfo;
import main.pojo.ReturnBean;
import main.pojo.enums.CMDType;
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
            registerInfo.setUserID((short)111);

            //将object序列化为byte[]
            //byte[] serialize = Serializer.serialize(registerInfo);
//            byte[] serialize = new byte[90];
//
//            byte[] bytes = LittleEndianDataConvert.shortToLittleEndianBytesByLength((short)111);
//            System.arraycopy(bytes,0 ,serialize,0,bytes.length);

            registerInfo.setPileCode("00750014630023");
            registerInfo.setVersion("1.0.0");
            registerInfo.setPileProjectType("feihong");
            registerInfo.setStartTimes(10);
            registerInfo.setUploadMode((byte) 1);
            registerInfo.setIntervalTime((short)10);
            outContents.put(CMDType.REGISTER_INFO.getCmdNum() ,registerInfo);
            ReturnBean bean = new ReturnBean();
            bean.setReturnMap(outContents);
            ChannelFuture future = channel.writeAndFlush(bean);
            if (future.isSuccess()) {
                LOG.debug("output put data successful =======");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
