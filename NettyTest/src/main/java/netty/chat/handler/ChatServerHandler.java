package netty.chat.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import net.sf.json.JSONObject;
import netty.chat.bean.UserInfo;

import java.util.Date;

/**
 * @Authuor Administrator
 * @Create 2016-10-25-14:06
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private UserListManager userListManager = UserListManager.userListManager();

    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String req = msg.text();
        JSONObject jsonReq = JSONObject.fromObject(req);
        if (!jsonReq.containsKey("req") || !jsonReq.containsKey("params")){
            ctx.close();
            return;
        }
        if(jsonReq.getString("req").equals("login")){
            handleLoginEvent(ctx, jsonReq.getJSONObject("params"));
        }else if(jsonReq.getString("req").equals("send_message")){
            handleMessageEvent(ctx, jsonReq.getJSONObject("params"));
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        userListManager.logout(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private void handleLoginEvent(ChannelHandlerContext ctx, JSONObject params){
        if(params.getString("username") != null && params.getString("password") != null){
            String username = params.getString("username");
            String password = params.getString("password");
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(username);
            userInfo.setPassword(password);
            userInfo = userListManager.login(ctx.channel(), userInfo);
            ackLogin(ctx, username, userInfo.getUserID());
            userListManager.broadcastUserList();
        }
    }

    private void handleMessageEvent(ChannelHandlerContext ctx, JSONObject params){
        if(params.getString("message") != null){
            UserInfo userinfo = userListManager.queryUser(ctx.channel());
            if ( userinfo != null ) {
                String message = params.getString("message");
                String username = userinfo.getUserName();
                int userid = userinfo.getUserID();

                // *) 响应投递消息的请求
                ackSendMessage(ctx);
                // *) 进行广播消息
                userListManager.broadcastMessage(username, userid, new Date().getTime(), message);
            }

        }
    }

    private void ackLogin(ChannelHandlerContext ctx, String username, int userid){
        JSONObject jo = new JSONObject();
        jo.put("resp", "login");
        jo.put("resultCode", 0);
        JSONObject joDatas = new JSONObject();
        joDatas.put("userid", userid);
        joDatas.put("username", username);
        jo.put("datas", joDatas);
        ctx.writeAndFlush(new TextWebSocketFrame(jo.toString()));

    }

    private void ackSendMessage(ChannelHandlerContext ctx){
        JSONObject jo = new JSONObject();
        jo.put("resp", "send_message");
        jo.put("resultCode", 0);
        JSONObject joDatas = new JSONObject();
        jo.put("datas", joDatas);
        ctx.writeAndFlush(new TextWebSocketFrame(jo.toString()));

    }
}
