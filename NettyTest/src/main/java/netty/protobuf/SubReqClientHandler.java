package netty.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Handler of SubReqClient
 *
 * @Authuor Administrator
 * @Create 2016-10-17-17:56
 */
public class SubReqClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("receive server message : [" + msg + "]");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReqOuterClass.SubscribeReq subReq(int i){
        SubscribeReqOuterClass.SubscribeReq.Builder builder = SubscribeReqOuterClass.SubscribeReq.newBuilder();
        builder.setSubReqID(i);
        builder.setUserName("xujian");
        builder.setProductName("Netty book for protobuf");
        List<String> addresses = new ArrayList<String>();
        addresses.add("jiangxi nanchang");
        addresses.add("shenzhen nanshan");
        addresses.add("beijing liulichang");
        builder.addAllAddress(addresses);
        return builder.build();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
