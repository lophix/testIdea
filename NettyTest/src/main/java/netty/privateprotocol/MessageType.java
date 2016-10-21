package netty.privateprotocol;

/**
 * Common data
 *
 * @Authuor Administrator
 * @Create 2016-10-21-11:03
 */
public class MessageType {
    public static final byte LOGIN_REQ = 1;
    public static final byte HANDSHAKE = 0;
    public static final byte REFUSE_CONNECT = -1;
    public static final byte LOGIN_RESP = 2;
    public static final byte HEARTBEAT_REQ = 3;
    public static final byte HEARTBEAT_RESP = 4;

}
