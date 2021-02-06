package com.sys.yang.service.impl;

import com.sys.yang.domain.User;
import com.sys.yang.remote.user.UserServiceClint;
import com.sys.yang.service.UserServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangLongFei 2020-12-26-20:40
 */
@Service
public class UserServiceRemoteImpl implements UserServiceRemote {

    @Autowired
    private UserServiceClint userServiceClint;
    /**
     * 新增用户
     */
    @Override
    public boolean insertUser(String user) {
        boolean b = userServiceClint.insertUser(user);
        return b;

    }

    /**
     * 查询用户
     *
     * @param user
     */
    @Override
    public List<User> selectUserList(User user) {
        return userServiceClint.selectUserList(user);
    }
}
