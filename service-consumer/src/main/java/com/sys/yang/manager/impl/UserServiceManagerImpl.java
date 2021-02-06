package com.sys.yang.manager.impl;

import com.alibaba.fastjson.JSON;
import com.sys.yang.domain.User;
import com.sys.yang.manager.UserServiceManager;
import com.sys.yang.service.impl.UserServiceRemoteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author yangLongFei 2020-12-26-20:42
 */
@Service
public class UserServiceManagerImpl implements UserServiceManager {

    @Autowired
    private UserServiceRemoteImpl userServiceRemote;

    @Override
    public boolean insterUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
//        user.setId("2020");
        user.setUserName("yang");
        user.setUserPassword("123");
        boolean b = userServiceRemote.insertUser(JSON.toJSONString(user));
        return b;
    }

    @Override
    public List<User> selectUserList(User user) {
        return userServiceRemote.selectUserList(user);
    }
}
