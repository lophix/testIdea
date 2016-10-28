package main.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import main.pojo.ReturnBean;

/**
 * @Authuor Administrator
 * @Create 2016-10-28-12:47
 */
public class DataPacketEncoder extends MessageToByteEncoder<ReturnBean> {
    protected void encode(ChannelHandlerContext ctx, ReturnBean msg, ByteBuf out) throws Exception {

    }
}
