package netty.privateprotocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Response handler for heart beat
 *
 * @Authuor Administrator
 * @Create 2016-10-21-13:16
 */
public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT_REQ){
            System.out.println("Receive client heart beat message : ----> " + message);
            NettyMessage heartBeat = buildHeartBeat();
            System.out.println("Send heart beat response to client : ----> " + heartBeat);
            ctx.writeAndFlush(heartBeat);
        }else{
            ctx.writeAndFlush(msg);
        }
    }

    private NettyMessage buildHeartBeat(){
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType(MessageType.HEARTBEAT_RESP);
        message.setHeader(header);
        message.setBody(MessageType.HEARTBEAT_RESP);
        return message;
    }
}
