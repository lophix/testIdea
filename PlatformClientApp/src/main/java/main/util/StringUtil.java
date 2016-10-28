package main.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String MD5(String toMd5){
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(toMd5.getBytes());
            StringBuffer buffer = new StringBuffer();
            for (byte by : digest.digest())
            {
                buffer.append(String.format("%02X", by));//将生成的字节MD５值转换成字符串
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean az09Pattern(String str){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
