package test;

/**
 * Created by Administrator on 2016/10/29.
 */
public class IPTest {
    public static void main(String[] args) {
        System.out.println(stringToLong("127.0.0.1"));
    }
    public static long stringToLong(String ip) {
        long ipLong = 0;
        String[] arr = ip.split("\\.");
        for (String ipDot : arr) {
            ipLong = ipLong * 256 + Integer.parseInt(ipDot);
        }
        return ipLong;
    }
}
