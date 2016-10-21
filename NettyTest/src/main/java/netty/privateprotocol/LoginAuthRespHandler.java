package netty.privateprotocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Server handshake handler
 *
 * @Authuor Administrator
 * @Create 2016-10-20-17:25
 */
public class LoginAuthRespHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getHeader().getType() == (byte)1){
            System.out.println("Login is OK");
            String body = (String) message.getBody();
            System.out.println("Received message body from client is " + body);
        }
        ctx.writeAndFlush(buildLoginResponse((byte)3));
    }

    private NettyMessage buildLoginResponse(byte result){
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType((byte)2);
        message.setHeader(header);
        message.setBody(result);
        return message;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
