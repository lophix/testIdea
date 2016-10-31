package main.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import main.pojo.DataPackageBean;

import java.util.List;

/**
 * @Authuor Administrator
 * @Create 2016-10-31-12:26
 */
public class PackageDataDecoder extends ByteToMessageDecoder {
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int readable = in.readableBytes();
        DataPackageBean dataPackageBean = new DataPackageBean();
        if (readable <= 9) {
            return;
        }
        in.markReaderIndex();
        byte byteI = in.readByte();
        String startDomainStrLow = byteToHexString(byteI);
        byteI = in.readByte();
        String startDomainStrHigh = byteToHexString(byteI);
        String startDomainStr = startDomainStrHigh + startDomainStrLow;
        dataPackageBean.setStartDomain(Integer.parseInt(startDomainStr, 16));
        short lengthDomain = in.readShort();

    }

    private String byteToHexString(byte b) {
        StringBuilder stringBuilder = new StringBuilder();
        int v = b & 0xff;
        String hv = Integer.toHexString(v);
        if (hv.length() < 2) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hv);
        return stringBuilder.toString();
    }

    private short reverseShort(short s){

        return s;
    }
}
