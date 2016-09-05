package nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

/**
 * Netty测试，客户端处理类
 *
 * @Authuor Administrator
 * @Create 2016-09-05-13:40
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = Logger.getLogger(TimeClientHandler.class);

    //连接成功后向server发送消息
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("TimeClientHandler.channelActive");
        String req = "QUERY TIME ORDER";
        ByteBuf encoded = ctx.alloc().buffer(4 * req.length());
        encoded.writeBytes(req.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }

    //接收server的消息，并打印
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("TimeClientHandler.channelRead");
        ByteBuf result = (ByteBuf) msg;
        byte[] bytes = new byte[result.readableBytes()];
        result.readBytes(bytes);
        System.out.println("Now is : " + new String(bytes, "UTF-8"));
        result.release();
    }
}
