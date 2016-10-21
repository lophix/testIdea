package netty.privateprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingEncoder;

/**
 * Message encoder util class
 *
 * @Authuor Administrator
 * @Create 2016-10-20-13:17
 */
public class NettyMarshallingEncoder extends MarshallingEncoder {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    public NettyMarshallingEncoder(MarshallerProvider provider) {
        super(provider);
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        super.encode(ctx, msg, out);
    }
}
