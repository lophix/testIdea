package main.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 时间转化帮助类
 */
public class DateUtil {


    private static final long ONE_DAY_INTERVAL = 1000 * 3600 * 24;

    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static final String YYMMDD = "yyyyMMdd";

    public static final String HHMMSS = "HH:mm:ss";

    /**
     * 获得当前日期，返回Date类型
     */
    public static Date getCurDate() {
        return new Date();
    }

    /**
     * 当前日期
     */
    public static String getCurrentDate() {
        return date2String(new Date(), YYYYMMDD);
    }

    /**
     * 传入格式化串
     *
     * @param formatStr
     * @return
     */
    public static String getCurrentDate(String formatStr) {
        return date2String(new Date(), formatStr);
    }

    /**
     * 当前时间
     */
    public static String getCurrentDatetime() {
        return date2String(new Date(), YYYYMMDDHHMMSS);
    }

    /**
     * 当前时间
     */
    public static String getDatetime(Date d) {
        return date2String(d, YYYYMMDDHHMMSS);
    }

    public static String getDatetimeExceptHMS(Date d) {

        return date2String(d, YYMMDD);
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

    /**
     * 比较StartDate和EndDate, startDate和endDate必须是凌晨的0:00:00:000.
     */
    public static int dateDiff(Date startDate, Date endDate) {
        assert (startDate.getTime() % ONE_DAY_INTERVAL == 0 && endDate
                .getTime() % ONE_DAY_INTERVAL == 0);
        long interval = endDate.getTime() - startDate.getTime();
        return (int) (interval / ONE_DAY_INTERVAL);
    }

    /**
     * 得到增加i天后的时间，如加（5）或减（-5）
     */
    public static Date addDay(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, i);
        return cal.getTime();
    }

    /**
     * 得到之前的几天
     */
    public static String getDateBefore(int before) {
        return date2String(new Date(System.currentTimeMillis()
                - ONE_DAY_INTERVAL * before), YYYYMMDD);
    }

    /**
     * 得到某天的DayOfWeek: 星期一为1...星期天为7;
     */
    public static int getDayOfWeek(Date theDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(theDay);
        return ((cal.get(Calendar.DAY_OF_WEEK) + 5) % 7) + 1;
    }

    /**
     * 得到一个日期的年份
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 得到一个日期的月份
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到一个日期的Day
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到一个日期的小时
     */
    public static int getHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 得到一个日期的分钟
     */
    public static int getMinite(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 得到一个日期的秒
     */
    public static int getSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.SECOND);
    }

    /**
     * 得到输入日期是该年第几周
     */
    public static int getWeekOfYear(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 得到当前月的第一天
     */
    public static String getMonthFirstDay() {
        return date2String(new Date(), "yyyy-MM-01");
    }

    /**
     * 得到几月后（前）的时间，如加（5）或减（-5）
     */
    public static Date addMonth(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, i);
        return cal.getTime();
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

    public static String longMillsToDateString(long millis) {
        if (millis <= 0) {
            return getCurrentDatetime();
        }
        Date date = new Date(millis);

        return getDatetime(date);
    }

    /**
     * 功能：如2015-11-02 转换为20151102
     *
     * @param millis
     * @return
     */
    public static int longMillsToDateInt(long millis) {
        Date date = null;
        if (millis <= 0) {
            date = new Date();
        } else {
            date = new Date(millis);
        }
        return Integer.parseInt(getDatetimeExceptHMS(date));
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
     * 得到之后几天
     */
    public static String getDateAfter(String dt, int days) {
        Date dt_time;
        dt_time = string2Date(dt, YYYYMMDD);
        return date2String(new Date(dt_time.getTime() + 1000 * 60 * 60 * 24
                * days), YYYYMMDD);
    }

    public static Date getNextYearLastDayOfMonthDate(int nyear) {
        Calendar g = Calendar.getInstance();
        g.add(Calendar.YEAR, nyear);
        // g.add(Calendar.MONTH, 1);
        g.set(Calendar.DAY_OF_MONTH, g.getActualMaximum(Calendar.DAY_OF_MONTH));
        return g.getTime();
        // SimpleDateFormat s=new SimpleDateFormat(YYYYMMDD);
        // String d=s.format(g.getTime());
        // return d;
    }

    /**
     * @param dtSrc
     * @return
     */
    public static Date getDateWeekEndDate(Date dtSrc) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dtSrc);
        int dofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dofweek == 1) {

        } else {
            cal.add(Calendar.DAY_OF_MONTH, 8 - dofweek);
        }
        // System.output.println(dofweek);
        return cal.getTime();
        //
        // return null;
    }

    public static int getLeftSecond() {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(
                curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH),
                curDate.get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) (tommorowDate.getTimeInMillis() - curDate
                .getTimeInMillis()) / 1000;
    }

    public static long getTime(String date) {
        SimpleDateFormat sf = new SimpleDateFormat(YYYYMMDDHHMMSS);
        try {
            return sf.parse(date).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

    public static String blockDateStr(String datestr, int length) {
        if (StringUtils.isNotBlank(datestr) && datestr.length() >= length) {
            return datestr.substring(0, length);
        } else {
            return datestr;
        }
    }

    /**
     * BDC码的字符串转换为Date
     */
    public static Date bcdBytesToDate(byte[] bcdBytes) {
        StringBuffer dateString = new StringBuffer();
        //最后一位不会影响到转换结果
        for (int i = 0; i < bcdBytes.length; i++) {
            dateString.append(HexByteUtil.byteToHexString(bcdBytes[i]));
        }
        if (dateString.toString().equals("0000000000000000")) {
            return null;
        } else {
            return DateUtil.string2Date(dateString.toString(), "yyyyMMddHHmmss");
        }
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


    /**
     * 检查日期格式,将客户端c tm 的格式错误进行修正 原 0111-02-31 18:05:19 修正为 2011-03-31 18:05:19
     *
     * @param strDate
     * @return
     */
    public static Pattern p_regEx_year_month_day_hh_mm_ss = Pattern
            .compile("^([\\d]{4})\\-([\\d]{1,2})\\-([\\d]{1,2}) ?([\\d]{1,2})?:?([\\d]{1,2})?:?([\\d]{1,2})?$");

    public static String cleckTmDateStr(String strDate) {
        Matcher m = p_regEx_year_month_day_hh_mm_ss.matcher(strDate);
        int fields[] = {0, 1, 1, 0, 0, 0};

        if (m.matches()) {
            int gc = m.groupCount();
            if (gc >= 1) {
                fields[0] = Integer.valueOf(m.group(1));
                // if(fields[0]>1900)
                // return strDate;
            }
            for (int i = 1; i < 6; i++) {
                if (gc >= i + 1) {
                    String str = m.group(i + 1);
                    if (str != null) {
                        fields[i] = Integer.valueOf(str);
                    } else {
                        break;
                    }
                }
            }

            if (fields[0] < 1900) {
                fields[0] = fields[0] + 1900;
                fields[1] = fields[1] + 1;
            }
            StringBuffer tbuff = new StringBuffer();
            tbuff.append(fields[0]).append("-").append(fields[1]).append("-")
                    .append(fields[2]).append(" ").append(fields[3])
                    .append(":").append(fields[4]).append(":")
                    .append(fields[5]);
            return date2String(string2Date(tbuff.toString(), YYYYMMDDHHMMSS),
                    YYYYMMDDHHMMSS);
        }
        return getCurrentDatetime();
    }

    public static int getOneAge(Date birthDay) {
        int yearOfBirth = DateUtil.getYear(birthDay);
        int yearOfCurrent = DateUtil.getYear(new Date());
        int age = yearOfCurrent - yearOfBirth;
        return age;
    }

    /**
     * 计算两个日期之间相隔的年整数(取整)
     *
     * @param timeFrom
     * @param timeTo
     * @return
     */
    public static int yearsDiff(long timeFrom, long timeTo) {
        return (int) ((timeTo - timeFrom) / (365.24220 * 24 * 60 * 60 * 1000));
    }

    public static Timestamp currentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    public static void main(String args[]) {

        System.out.println(blockDateStr("2012-11-29 15:18:12 0", 18));
        Date d = DateUtil.getNextYearLastDayOfMonthDate(1);
        d = DateUtil.getDateWeekEndDate(d);
    }

}
