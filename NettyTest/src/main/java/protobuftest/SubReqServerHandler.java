package protobuftest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * SubReqServer's handler
 *
 * @Authuor Administrator
 * @Create 2016-10-17-10:21
 */
public class SubReqServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReqOuterClass.SubscribeReq req = (SubscribeReqOuterClass.SubscribeReq) msg;
        if("xujian".equals(req.getUserName())){
            System.out.println("Service accept client subscribe req : [" + req.toString() + "]");
        }
        ctx.writeAndFlush(resp(req.getSubReqID()));
    }

    private SubscribeRespOuterClass.SubscribeResp resp(int subReqID){
        SubscribeRespOuterClass.SubscribeResp.Builder builder = SubscribeRespOuterClass.SubscribeResp.newBuilder();
        builder.setSubReqID(subReqID);
        builder.setRespCode(0);
        builder.setDesc("Netty book order succeed, 3 days later, sent to designated address");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();   //exception close the channel
    }
}
