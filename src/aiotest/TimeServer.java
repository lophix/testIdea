package aiotest;

/**
 * AIO测试，服务类
 *
 * @Authuor Administrator
 * @Create 2016-09-04-15:33
 */
public class TimeServer {
    public static void main(String[] args){
        int port = 8080;
        AsyncTimeServerHandler asyncTimeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(asyncTimeServerHandler, "AIO-TEST-SERVER-001").start();
    }
}
