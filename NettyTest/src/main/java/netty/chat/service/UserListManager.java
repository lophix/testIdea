package netty.chat.service;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netty.chat.bean.UserInfo;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Manager for user list
 *
 * @Authuor Administrator
 * @Create 2016-10-27-10:39
 */
public class UserListManager {
    private Map<Channel, UserInfo> usersMap = Collections.synchronizedMap(new HashMap<Channel, UserInfo>());
    private AtomicInteger useridGen = new AtomicInteger(100);
    private static UserListManager userListManager = new UserListManager();

    public static UserListManager userListManager(){
        if (userListManager == null) {
            userListManager = new UserListManager();
        }
        return userListManager;
    }

    private UserListManager(){

    }

    public UserInfo login(Channel channel, String username){
        if(!usersMap.containsKey(channel)){
            int userID = useridGen.addAndGet(1);
            usersMap.put(channel, new UserInfo(username, userID));
            userListManager.broadcastMessage("Server", 1, new Date().getTime(), "Welcome " + username + " enter chat room !");
        }
        return usersMap.get(channel);
    }

    public void logout(Channel channel){
        if (usersMap.containsKey(channel)){
            usersMap.remove(channel);
            broadcastUserList();
        }
    }

    public UserInfo queryUser(Channel channel){
        return usersMap.get(channel);
    }

    public void broadcastMessage(String username, int userid, long timestamp, String message){
        JSONObject resp = new JSONObject();
        resp.put("resp", "receive_message");
        resp.put("resultCode", 0);
        JSONObject jsonDatas = new JSONObject();
        jsonDatas.put("username", username);
        jsonDatas.put("userid", userid);
        jsonDatas.put("message", message);
        jsonDatas.put("timestamp", new Date().getTime());
        resp.put("datas", jsonDatas);

        String respMessage = resp.toString();
        for (Map.Entry<Channel, UserInfo> entry : usersMap.entrySet()){
            Channel channel = entry.getKey();
            channel.writeAndFlush(new TextWebSocketFrame(respMessage));
        }
    }

    public void broadcastUserList(){
        JSONObject resp = new JSONObject();
        resp.put("resp", "userlist");
        resp.put("resultCode", 0);

        JSONObject jsonDatas = new JSONObject();
        JSONArray userList = new JSONArray();
        for (Map.Entry<Channel, UserInfo> entry : usersMap.entrySet()){
            UserInfo userInfo  = entry.getValue();
            JSONObject user = new JSONObject();
            user.put("username", userInfo.getUserName());
            user.put("userid", userInfo.getUserID());
            userList.add(user);
        }
        jsonDatas.put("users", userList);
        resp.put("datas", jsonDatas);
        String respMessage = resp.toString();
        for (Map.Entry<Channel, UserInfo> entry : usersMap.entrySet()){
            Channel channel = entry.getKey();
            channel.writeAndFlush(new TextWebSocketFrame(respMessage));
        }
    }
}
