package nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Netty测试，服务器处理类
 *
 * @Authuor Administrator
 * @Create 2016-09-05-11:37
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger = Logger.getLogger(TimeServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("TimeServerHandler.channelRead");
        ByteBuf result = (ByteBuf) msg;
        byte[] bytes = new byte[result.readableBytes()];
        //msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中
        result.readBytes(bytes);
        String body = new String(bytes, "UTF-8");
        //接收打印客户端信息
        System.out.println("The time server receive order : " + body);
        //释放资源，很关键
        result.release();
        String resp = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date().toString() : "BAD ORDER";
        //在当前场景下发送的数据必须转换成ByteBuf数组
        ByteBuf encoded = ctx.alloc().buffer(4 * resp.length());
        encoded.writeBytes(resp.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
