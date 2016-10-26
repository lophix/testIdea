package netty.chat.websocket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Chat client
 *
 * @Authuor Administrator
 * @Create 2016-10-25-14:05
 */
@Deprecated
public class ChatClient {
    private void connect(String remoteServer, int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline cp = ch.pipeline();
                    cp.addLast(new HttpClientCodec());
                    cp.addLast(new HttpObjectAggregator(65535));
                    cp.addLast(new ChunkedWriteHandler());
                    cp.addLast(new WebSocketClientExtensionHandler());
                    cp.addLast(new ChatClientHandler());
                }
            });
            ChannelFuture f = b.connect(remoteServer, port).sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String remoteServer = "127.0.0.1";
        int port = 8080;
        new ChatClient().connect(remoteServer, port);
    }
}
