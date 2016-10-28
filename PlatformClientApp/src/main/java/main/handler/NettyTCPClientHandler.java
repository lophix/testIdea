package main.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Authuor Administrator
 * @Create 2016-10-28-12:50
 */
public class NettyTCPClientHandler extends SimpleChannelInboundHandler<Object> {

    private static final Logger LOG = LogManager.getLogger(NettyTCPClientHandler.class);
    private ClientTask task;

    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
       LOG.info("======= {} " , msg.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        task = new ClientTask(ctx.channel());
        task.commitRequest_106("");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("==== channelReadComplete ");
        channelActive(ctx);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOG.warn("Unexpected exception from channel.{} ", cause.getMessage());
        ctx.close();
    }
}
