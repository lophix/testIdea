package netty.chat.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import net.sf.json.JSONObject;

/**
 * @Authuor Administrator
 * @Create 2016-10-25-14:06
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String req = msg.text();
        JSONObject jsonReq = JSONObject.fromObject(req);
        if (!jsonReq.containsKey("req") || !jsonReq.containsKey("params")){
            ctx.close();
            return;
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
