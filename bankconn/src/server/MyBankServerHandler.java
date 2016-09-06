package server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

/**
 * 服务器处理类
 *
 * @Authuor Administrator
 * @Create 2016-09-06-19:59
 */
public class MyBankServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    public static Logger logger = Logger.getLogger(MyBankServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
        if (!fullHttpRequest.decoderResult().isSuccess()) {
            sendError(channelHandlerContext, HttpResponseStatus.BAD_REQUEST);
            logger.info("http请求解码失败");
            return;
        }
        if (fullHttpRequest.method() != HttpMethod.GET) {
            sendError(channelHandlerContext, HttpResponseStatus.METHOD_NOT_ALLOWED);
            logger.info("方法不合法");
            return;
        }
        String uri = fullHttpRequest.uri();
        if ("/".equals(uri)) {
            sendForm(channelHandlerContext);
            return;
        }
    }

    private void sendForm(ChannelHandlerContext channelHandlerContext) {
        String resp = "<html><body><h1>Hello World!</h1><form></form></body></html>";
        ByteBuf writeBuf = channelHandlerContext.alloc().buffer(4 * resp.length());
        writeBuf.writeBytes(resp.getBytes());
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer(writeBuf));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");
        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status,
                Unpooled.copiedBuffer("Failure: " + status.toString() + "\r\n", CharsetUtil.UTF_8));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
