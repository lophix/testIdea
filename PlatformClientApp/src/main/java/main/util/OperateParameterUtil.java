package main.util;

import main.output.IntParameterBean;
import main.output.IntParameterType;

/**
 * @Authuor Administrator
 * @Create 2016-10-28-15:58
 */
public class OperateParameterUtil {

    /*public static byte[] getBytesFromCharsParameter(CharsParameter bean) {
        if (bean == null) {
            return null;
        }
        return setString(bean.getValue(), bean.getType());
    }

    private static byte[] setString(String cmdContents, OperateCmdOfCharsOutboundInfo.CharsOperateParameterType type) {
        byte[] bytes;
        if (type == OperateCmdOfCharsOutboundInfo.CharsOperateParameterType.STANDARD_TIME) {
            //时间类型单独处理
            bytes = DateUtil.dateCharsToBCDCode(cmdContents, "yyyyMMddHHmmss");
        } else {
            bytes = StringByteConvert.stringToBytes(cmdContents, type.getFieldLength());
        }
        return bytes;
    }*/


    /**
     * 整型参数列表
     */
    public static byte[] getBytesFromIntParameter(IntParameterBean bean) {
        if (bean == null) {
            return null;
        }
        return getBytes((int) bean.getValue(), bean.getPrmType());
    }

    private static byte[] getBytes(int value, IntParameterType prmType) {
        return LittleEndianDataConvert.intToLittleEndianBytes((int)value);
    }
}
