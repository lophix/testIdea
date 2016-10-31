package main.output;

import main.pojo.IOutputDataPackage;
import main.pojo.RegisterUploadInfo;
import main.pojo.enums.CMDType;
import main.util.YSArraysUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @Authuor Administrator
 * @Create 2016-10-28-13:46
 */
public class CMD106Processor implements IOutputDataPackage {
    private static Logger LOG = LogManager.getLogger(CMD106Processor.class);

    @Override
    public byte[] outputDataRectify(CMDType cmdType, Object value) {
        RegisterUploadInfo info = (RegisterUploadInfo) value;
        byte[] result ;

        byte[] bytes = YSArraysUtil.getBytes(info.getUserID(), 2);
        byte[] bytes1 = YSArraysUtil.getBytes(info.getCommandsNo(), 2);
        byte[] bytes2 = YSArraysUtil.getBytes(info.getPileCode(), 32);
        byte[] bytes3 = new byte[1];
        byte[] bytes4 = new byte[]{(byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00};
        byte[] bytes5 = new byte[]{(byte) 0xaa, (byte) 0xfa};
        byte[] bytes6 = YSArraysUtil.getBytes(info.getStartTimes(), 4);
        byte[] bytes7 = YSArraysUtil.getBytes(info.getUploadMode(), 1);
        byte[] bytes8 = YSArraysUtil.getBytes(info.getIntervalTime(), 2);
        //byte[] bytes9 = new byte[1];
        byte[] bytes10 = YSArraysUtil.getBytes(info.getGunNum(), 1);
        byte[] bytes11 = YSArraysUtil.getBytes(info.getIntervalHeartbeat(), 1);
        byte[] bytes12 = YSArraysUtil.getBytes(info.getHeartbeatCheckTimes(), 1);
        byte[] bytes13 = YSArraysUtil.getBytes(info.getPileRecordNum(), 4);
        byte[] bytes14 = YSArraysUtil.getBytes(info.getPileCurTimes(), 8);
        byte[] bytes15 = YSArraysUtil.getBytes(info.getLastChargingTime(), 8);
        byte[] bytes16 = YSArraysUtil.getBytes(info.getLastStartTime(), 8);
        byte[] bytes17 = YSArraysUtil.getBytes(info.getRegisterPassword(), 8);
        byte[] bytes18 = YSArraysUtil.getBytes(info.getPileLocalIMEIOrMAC(), 32);

        result = YSArraysUtil.concatAll(bytes, bytes1, bytes2, bytes3, bytes4, bytes5, bytes6, bytes7, bytes8, /*bytes9,*/ bytes10, bytes11,
                bytes12, bytes13, bytes14, bytes15, bytes16, bytes17, bytes18);
        LOG.info("save cmd3 operate parameter successful ");
        return result;
    }
}
