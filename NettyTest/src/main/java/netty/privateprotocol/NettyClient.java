package netty.privateprotocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Private protocol test client
 *
 * @Authuor Administrator
 * @Create 2016-10-20-17:41
 */
public class NettyClient {
    private void connect(String remoteServer, int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new NettyMessageDecoder(1024*1024, 4, 4, -8, 0));
                    ch.pipeline().addLast(new NettyMessageEncoder());
                    ch.pipeline().addLast(new LoginAuthReqHandler());
                }
            });
            ChannelFuture f = b.connect(remoteServer, port).sync();
            System.out.println("Netty client connected at port : " + port);
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String remoteServer = "127.0.0.1";
        int port = 8080;
        new NettyClient().connect(remoteServer, port);
    }
}
