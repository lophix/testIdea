package netty.chat.dao;

import netty.chat.bean.UserInfo;

/**
 * Connect database , database operation
 *
 * @Authuor Administrator
 * @Create 2016-10-27-15:19
 */
public interface UserInfoDao {
    UserInfo login(String username, String password);
}
