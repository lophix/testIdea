package netty.udp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ThreadLocalRandom;

/**
 * UDP Test Server Handler
 *
 * @Authuor Administrator
 * @Create 2016-10-19-16:46
 */
public class ChineseProverbServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    //proverb list
    private static final String[] DICTIONARY = {"只要功夫深铁杵磨成针。", "旧时王谢堂前燕，飞入寻常百姓家。", "洛阳亲友如相问，一片冰心在玉壶。",
    "一寸光阴一寸金，寸金难买寸光阴。", "老骥伏枥，志在千里。烈士暮年，壮心不已。"};

    private String nextQuote(){
        int quoId = ThreadLocalRandom.current().nextInt(DICTIONARY.length);
        return DICTIONARY[quoId];
    }

    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String req = msg.content().toString(CharsetUtil.UTF_8);
        System.out.println(req);
        if("谚语字典查询？".equals(req)){
            ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("谚语查询结果 : " + nextQuote(), CharsetUtil.UTF_8), msg.sender()));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
