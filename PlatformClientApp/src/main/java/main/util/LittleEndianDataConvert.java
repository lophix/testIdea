package main.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LittleEndianDataConvert {
    private static Logger logger = LogManager.getLogger(LittleEndianDataConvert.class);
    /**
     * 将int转为低字节在前，高字节在后的byte数组
     *
     * @param n
     * int
     * @return byte[]
     */
    public static byte[] intToLittleEndianBytes(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        return b;
    }

    public static byte[] shortToLittleEndianBytesByLength(short s , int bytesLength){
            byte[] resultBytes = new byte[bytesLength];

            byte[] encodeBytes ;
            try {
                encodeBytes = shortToLittleEndianBytesByLength(s);

                if (encodeBytes.length >=2 ) {
                    System.arraycopy(encodeBytes,0, resultBytes, 0, 2);

                } else {
                    logger.warn("convert failed {}", s);
                }
            } catch (Exception e) {
                logger.error("data decoder exception  content {} ,length {} ,  {}", s ,bytesLength ,e);
            }
            return resultBytes;
    }

    /**
     * 将short转为低字节在前，高字节在后的byte数组
     *
     * @param n
     * short
     * @return byte[]
     */
    public static byte[] shortToLittleEndianBytesByLength(short n) {
        byte[] b = new byte[2];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        return b;
    }

    /**
     * 将float转为低字节在前，高字节在后的byte数组
     */
    public static byte[] floatToLittleEndianBytes(float f) {
        return intToLittleEndianBytes(Float.floatToRawIntBits(f));
    }

    /**
     * 将低字节数组转换为int
     *
     * @param b
     * byte[]
     * @return int
     */
    public static int littleEndianBytesToInt(byte[] b) {
        int s = 0;
        for (int i = 0; i < 3; i++) {
            if (b[3 - i] >= 0) {
                s = s + b[3 - i];
            } else {
                s = s + 256 + b[3 - i];
            }
            s = s * 256;
        }
        if (b[0] >= 0) {
            s = s + b[0];
        } else {
            s = s + 256 + b[0];
        }
        return s;
    }


    /**
     * 低字节数组到short的转换
     *
     * @param b
     * byte[]
     * @return short
     */
    public static short littleEndianBytesToShort(byte[] b) {
        int s = 0;
        if (b[1] >= 0) {
            s = s + b[1];
        } else {
            s = s + 256 + b[1];
        }
        s = s * 256;
        if (b[0] >= 0) {
            s = s + b[0];
        } else {
            s = s + 256 + b[0];
        }
        short result = (short) s;
        return result;
    }


    /**
     * 低字节数组转换为float
     *
     * @param b
     * byte[]
     * @return float
     */
    public static float littleEndianBytesToFloat(byte[] b) {
        int i = 0;
        Float F = new Float(0.0);
        i = ((((b[3] & 0xff) << 8 | (b[2] & 0xff)) << 8) | (b[1] & 0xff)) << 8
                | (b[0] & 0xff);
        return F.intBitsToFloat(i);
    }

}
