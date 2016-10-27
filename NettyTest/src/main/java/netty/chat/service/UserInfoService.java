package netty.chat.service;

import netty.chat.bean.UserInfo;

/**
 * user service
 *
 * @Authuor Administrator
 * @Create 2016-10-27-16:35
 */
public interface UserInfoService {
    UserInfo login(String username, String password);
}
