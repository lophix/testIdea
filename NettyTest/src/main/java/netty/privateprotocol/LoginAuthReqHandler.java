package netty.privateprotocol;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Client handshake handler
 *
 * @Authuor Administrator
 * @Create 2016-10-20-16:58
 */
public class LoginAuthReqHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(buildLoginReq());
    }

    private NettyMessage buildLoginReq(){
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType((byte)1);
        message.setHeader(header);
        message.setBody("Its request");
        return message;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getHeader().getType() == (byte)2){
            System.out.println("Received from server response");
        }
        ctx.fireChannelRead(msg);
    }
}
