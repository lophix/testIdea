package netty.privateprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.marshalling.MarshallingEncoder;

/**
 * Message encoder util class
 *
 * @Authuor Administrator
 * @Create 2016-10-20-13:17
 */
public class NettyMarshallingEncoder {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    MarshallingEncoder marshaller;

    public NettyMarshallingEncoder(){
        marshaller = MarshallingCodecFactory.buildMarshallingEncoder();
    }

    protected void encoder(Object msg, ByteBuf out){
        int lengthPos = out.writerIndex();
        out.writeBytes(LENGTH_PLACEHOLDER);

    }
}
