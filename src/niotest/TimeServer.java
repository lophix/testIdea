package niotest;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

/**
 * NIO创建的时间服务器
 *
 * @Authuor Administrator
 * @Create 2016-09-03-15:00
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
           /* acceptorSvr.bind(new InetSocketAddress(InetAddress.getByName("IP"), port));
            acceptorSvr.configureBlocking(false);
            Selector selector = Selector.open();
            new Thread(new ReactorTask()).start();*/

    }
}
