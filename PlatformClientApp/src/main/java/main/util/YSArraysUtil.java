package main.util;

import java.util.Arrays;
import java.util.Date;

public class YSArraysUtil {
    /**
     * 合并多个数组
     */
    public static byte[] concatAll(byte[] first, byte[]... rest) {
        int totalLength = first.length;
        for (byte[] array : rest) {
            totalLength += array.length;
        }
        byte[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (byte[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }


    /**
     * 将字段值转为对应的byte数组
     *
     * @return
     */
    public static byte[] getBytes(Object data, int fieldLength) {
        byte[] result = new byte[fieldLength];

        if (data instanceof Integer) {
            //整形
            result = IntNumDataTypeCodec.encodeIntDataToHexBytes((int) data, fieldLength);

        } else if (data instanceof String) {
            result = StringByteConvert.stringToBytes((String) data, fieldLength);

        } else if (data instanceof Date) {
            result = DateUtil.DateToBcdBytes((Date) data);

        } else if (data instanceof Byte) {
            result = new byte[]{(byte) data};

        } else if (data instanceof Short) {
            result = LittleEndianDataConvert.shortToLittleEndianBytesByLength((short) data, 2);

        } else if (data instanceof Long) {
            //// TODO: 2015/12/30 long数据类型转换暂未实现
        }
        return result;
    }

}
