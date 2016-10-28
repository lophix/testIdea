package main;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import main.handler.DataPacketEncoder;
import main.handler.NettyTCPClientHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Client TCP thread
 *
 * @Authuor Administrator
 * @Create 2016-10-28-12:30
 */
public class NettyTCPClient extends  Thread {

    private static final Logger LOG = LogManager.getLogger(NettyTCPClient.class);

    private final String host;
    private final int port;

    public NettyTCPClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO),
                            new DataPacketEncoder(),
                            new NettyTCPClientHandler());
                }
            });
            ChannelFuture f = b.connect(host, port).sync();
            LOG.info("Connected host : {} and port : {}", host, port);
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            group.shutdownGracefully();
        }
    }
}
