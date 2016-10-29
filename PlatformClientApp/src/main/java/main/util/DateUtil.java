package main.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 时间转化帮助类
 */
public class DateUtil {

    /**
     * 获得当前日期，返回Date类型
     */
    public static Date getCurDate() {
        return new Date();
    }


    /**
     * 日期按照指定格式转换为字符串
     */
    public static String date2String(Date date, String formatStr) {
        return date2String(date, formatStr, Locale.getDefault());
    }

    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date string2Date(String strDate, String formatStr) {
        return string2Date(strDate, formatStr, Locale.getDefault());
    }

    /**
     * String类型的字符串装换为bcd码的byte数组
     *
     * @param strDate   字符日期
     * @param formatStr 格式
     * @return bcd码的数组
     */
    public static byte[] dateCharsToBCDCode(String strDate, String formatStr) {
        return DateToBcdBytes(string2Date(strDate, formatStr));
    }


    private static Date string2Date(String strDate, String formatStr,
                                    Locale locale) {
        Date date = null;
        try {
            date = new SimpleDateFormat(formatStr, locale).parse(strDate);
        } catch (ParseException e) {
        }
        return date;
    }


    private static String date2String(Date date, String formatStr, Locale locale) {
        try {
            Format format = new SimpleDateFormat(formatStr, locale);
            return format.format(date);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 日期转换为BCD
     * 0x20 0x15 0x07 0x22 0x13 0x16 0x15 0xff
     */
    public static byte[] DateToBcdBytes(Date date) {
        byte[] result = new byte[]{0, 0, 0, 0, 0, 0, 0,};
        byte[] reservedBit = new byte[]{(byte) 0xFF};
        try {
            if (date != null) {
                String dateStr = date2String(date, "yyyyMMddHHmmss");
                //转换为hex String
                result = Hex.decodeHex(dateStr.toCharArray());
            }
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        return YSArraysUtil.concatAll(result, reservedBit);
    }

}
