package aiotest;

/**
 * AIO测试，客户端类
 *
 * @Authuor Administrator
 * @Create 2016-09-04-15:34
 */
public class TimeClient {
    public static void main(String[] args){
        int port = 8080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-TEST-CLIENT-001").start();
    }
}
