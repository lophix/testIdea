package netty.chat.dao.impl;

import netty.chat.bean.UserInfo;
import netty.chat.dao.UserInfoDao;
import netty.chat.dbconnect.DBConnecter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Connect to database , operation DB
 *
 * @Authuor Administrator
 * @Create 2016-10-27-15:22
 */
public class UserInfoDaoImpl implements UserInfoDao {
    public UserInfo login(String username, String password) {
        Connection conn = DBConnecter.getConnection();
        String sql = "SELECT * FROM userinfo WHERE username=? AND password=?";
        UserInfo userInfo = new UserInfo();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet result = pstmt.executeQuery();
            if (result.next()){
                userInfo.setUserID(result.getInt(1));
                userInfo.setUserName(result.getString(2));
                userInfo.setPassword(result.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
