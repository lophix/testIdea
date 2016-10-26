package netty.chat.websocket;

import io.netty.channel.*;

/**
 * @Authuor Administrator
 * @Create 2016-10-25-14:09
 */
@Deprecated
public class ChatClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String value = msg.toString();
        if (value != null) {
            System.out.println(value);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
