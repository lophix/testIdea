package main.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created by qudong on 2015/12/14.
 */
public class StringByteConvert {
    /**
     * 将String转为byte数组
     */
    public static byte[] stringToBytes(String s, int length) {
        while (s.getBytes().length < length) {
            s += "\0";
        }
        return s.getBytes();
    }

    /**
     * 多个一样的数据
     */
    public static String sameChars(String s, int length) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(s);
        }
        return buffer.toString();
    }
    /**
     * 多个一样的数据
     */
    public static String checkAllZero(String s) {
        String ss = s.replace("0","");
        if(StringUtils.isNotEmpty(ss)){
            return s;
        }
        return ss;
    }

    /**
     * 将字节数组转换为String
     *
     * @param b
     * byte[]
     * @return String
     */
    public static String bytesToString(byte[] b) {
        StringBuffer result = new StringBuffer("");
        int length = b.length;
        for (int i = 0; i < length; i++) {
            result.append((char) (b[i] & 0xff));
        }
        return result.toString().trim();
    }

    /**
     * 将字符串转换为byte数组
     *
     * @param s
     * String
     * @return byte[]
     */
    public static byte[] stringToBytes(String s) {
        return s.getBytes();
    }

    /**
     * 打印byte数组
     */
    public static void printBytes(byte[] bb) {
        int length = bb.length;
        for (int i = 0; i < length; i++) {
            System.out.print(bb + " ");
        }
        System.out.println("");
    }

    public static void logBytes(byte[] bb) {
        int length = bb.length;
        String ut = "";
        for (int i = 0; i < length; i++) {
            ut = ut + bb + " ";
        }
        System.out.println(ut);
    }

    /**
     * 将byte数组中的元素倒序排列
     */
    public static byte[] bytesReverseOrder(byte[] b) {
        int length = b.length;
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[length - i - 1] = b[i];
        }
        return result;
    }


}
