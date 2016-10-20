package netty.privateprotocol;

import io.netty.handler.codec.marshalling.MarshallingEncoder;

/**
 * Message encoder util class
 *
 * @Authuor Administrator
 * @Create 2016-10-20-13:17
 */
public class NettyMarshallingEncoder {
    private static final byte[] PLACEHOLDER = new byte[4];
    MarshallingEncoder marshaller;

    public NettyMarshallingEncoder(){
        marshaller = MarshallingCodecFactory.buildMarshallingEncoder();
    }

}
