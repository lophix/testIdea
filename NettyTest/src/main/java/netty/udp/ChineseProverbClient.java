package netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * Chinese proverb test client
 *
 * @Authuor Administrator
 * @Create 2016-10-20-9:14
 */
public class ChineseProverbClient {
    private void run(int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioDatagramChannel.class).option(ChannelOption.SO_BROADCAST, true).handler(new ChineseProverbClientHandler());
            Channel ch = b.bind(0).sync().channel();
            //Send UDP broadcast to all machine that in the same network segment
            ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("谚语字典查询？", CharsetUtil.UTF_8), new InetSocketAddress("255.255.255.255", port))).sync();
            if (!ch.closeFuture().await(15000)){
                System.out.println("Query has overtime !");
            }
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        new ChineseProverbClient().run(port);
    }
}
