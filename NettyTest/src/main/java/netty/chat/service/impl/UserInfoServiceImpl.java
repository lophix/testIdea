package netty.chat.service.impl;

import netty.chat.bean.UserInfo;
import netty.chat.dao.UserInfoDao;
import netty.chat.dao.impl.UserInfoDaoImpl;
import netty.chat.service.UserInfoService;

/**
 * user service implements class
 *
 * @Authuor Administrator
 * @Create 2016-10-27-16:36
 */
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoDao userInfoDao = new UserInfoDaoImpl();

    public UserInfo login(String username, String password) {
        return userInfoDao.login(username, password);
    }
}
