package main;

/**
 * @Authuor Administrator
 * @Create 2016-10-31-11:35
 */
public class ServerMain {
    public static void main(String[] args) {
        int port = 8057;
        new NettyTCPServer().bind(port);
    }
}
