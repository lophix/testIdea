package netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * Test SubscribeReqOutClass which create by proto-buffers
 *
 * @Authuor Administrator
 * @Create 2016-10-14-16:24
 */
public class TestSubscribeReqProto {

    private static byte[] encode(SubscribeReqOuterClass.SubscribeReq req){
        return req.toByteArray();
    }

    private static SubscribeReqOuterClass.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqOuterClass.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqOuterClass.SubscribeReq createSubscribeReq(){
        SubscribeReqOuterClass.SubscribeReq.Builder builder = SubscribeReqOuterClass.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("xujian");
        builder.setProductName("protobuf test");
        List<String> address = new ArrayList<String>();
        address.add("shenzhen kejicheng");
        address.add("shenzhen");
        address.add("beijing liulichang");
        builder.addAllAddress(address);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqOuterClass.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode:" + req.toString());
        SubscribeReqOuterClass.SubscribeReq req1 = decode(encode(req));
        System.out.println("After decode:" + req.toString());
        System.out.println("Assert equal: -->" + req1.equals(req));
    }
}
