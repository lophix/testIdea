package main;

/**
 * Client main class
 *
 * @Authuor Administrator
 * @Create 2016-10-28-12:34
 */
public class ClientMain {

    public static void main(String[] args) throws InterruptedException {
        String host = "127.0.0.1";
        int port = 8080;
        NettyTCPClient clientTask = new NettyTCPClient(host, port);
        clientTask.start();
        clientTask.join();
    }

}
