package com.sys.yang.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sys.yang.api.UserServiceApi;
import com.sys.yang.domain.User;
import com.sys.yang.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangLongFei 2020-12-26-19:37
 */
@RestController
public class UserServiceApiImpl implements UserServiceApi {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public boolean insertUser(String user) {
        boolean b = userService.insertUser(JSON.parseObject(user,User.class));
        return b;
    }

    @Override
    public List<User> selectUserList(User user) {
        return userService.selectUserList(user);
    }
}
