package netty.websocket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Handler for WebSocket Server
 *
 * @Authuor Administrator
 * @Create 2016-10-19-14:20
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger logger = Logger.getLogger(WebSocketServerHandler.class);

    private WebSocketServerHandshaker handshaker;

    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        //Conventional http request access
        if (msg instanceof  FullHttpRequest)
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        //WebSocket request access
        if (msg instanceof WebSocketFrame)
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req){
        //If http decode fail, return http exception
        if (!req.decoderResult().isSuccess() || (!"websocket".equals(req.headers().get("Upgrade")))){
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        //Construct handshake response, local test
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://localhost:8080/websocket", null, false);
        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        }else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame){
        //if the common is close link
        if (frame instanceof CloseWebSocketFrame){
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }

        //if its ping message
        if (frame instanceof PingWebSocketFrame){
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }

        //return response message
        String request = ((TextWebSocketFrame) frame).text();
        ctx.channel().write(new TextWebSocketFrame(request + ",Welcome to use Netty WebSocket Service, Now is : " + new Date().toString()));
    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res){
        //return response to client
        if (res.status().code() != 200){
            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
            HttpUtil.setContentLength(res, buf.readableBytes());
        }

        //if there are not Keep-Alive, close the link
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!HttpUtil.isKeepAlive(res) || res.status().code() != 200)
            f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
