package util;

import java.util.Random;

/**
 * 随机工具类
 *
 * @Authuor Administrator
 * @Create 2016-09-07-14:40
 */
public class MyRandomUtil {
    public static String randomString(int length){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
