package netty.privateprotocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;


/**
 * Netty message encoder
 *
 * @Authuor Administrator
 * @Create 2016-10-20-12:23
 */
public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {

    NettyMarshallingEncoder marshallingEncoder;

    public NettyMessageEncoder(){
        this.marshallingEncoder = new NettyMarshallingEncoder();
    }

    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, List<Object> out) throws Exception {

    }
}
