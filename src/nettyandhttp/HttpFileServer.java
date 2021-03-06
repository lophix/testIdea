package nettyandhttp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * netty+Http测试，文件服务器
 *
 * @Authuor Administrator
 * @Create 2016-09-06-9:16
 */
public class HttpFileServer {
    private static final String DEFAULT_URL = "/src/";

    public void run(final int port, final String url) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                    socketChannel.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                    socketChannel.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                    socketChannel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                    socketChannel.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));

                }
            });
            ChannelFuture f = b.bind("127.0.0.1", port).sync();
            System.out.println("HTTP 文件目录服务器启动，网址是：" + "http://127.0.0.1:" + port + url);
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        String url = DEFAULT_URL;
        new HttpFileServer().run(port, url);
    }

}
