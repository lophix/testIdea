package main.output;

import main.pojo.enums.CMDType;
import main.util.IntNumDataTypeCodec;
import main.util.OperateParameterUtil;
import main.util.X;
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
        OperateCmdOfIntOutboundInfo oinfo = (OperateCmdOfIntOutboundInfo) value;

        byte[] bytes = YSArraysUtil.getBytes(oinfo.getUserID(), 2);
        byte[] bytes1 = YSArraysUtil.getBytes(oinfo.getCommandsNo(), 2);
        byte[] bytes2 = YSArraysUtil.getBytes(oinfo.getCommandType(), 1);

        byte[] bytes3 = YSArraysUtil.getBytes(oinfo.getCmdStartPosition(), 4);
        byte[] bytes4 = new byte[]{Byte.valueOf(Integer.toString(oinfo.getCmdParameterNumbers()))};
        byte[] bytes5 = YSArraysUtil.getBytes(oinfo.getCmdLength(), 2); //参数的长度 单位：字节

        byte[] prmArr = X.createArrays(0);
        for (int i = 0; i < oinfo.getParameterList().size(); i++) {
            IntParameterBean tempBean = oinfo.getParameterList().get(i);
            if (tempBean.getPrmType() == IntParameterType.REGISTER_INFO) {
                //ip转换
                byte[] ipAddress = IntNumDataTypeCodec.encodeIPLongDataToHexBytes(tempBean.getValue(), 4);
                prmArr = YSArraysUtil.concatAll(prmArr,ipAddress);
            } else {
                prmArr = YSArraysUtil.concatAll(prmArr, OperateParameterUtil.getBytesFromIntParameter(tempBean));
            }
        }
        byte[] bytes6 = YSArraysUtil.concatAll(bytes, bytes1, bytes2, bytes3, bytes4, bytes5, prmArr);

        return bytes6;
    }
}
