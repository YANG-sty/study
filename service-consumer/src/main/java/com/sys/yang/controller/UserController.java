package com.sys.yang.controller;

import com.sys.yang.domain.User;
import com.sys.yang.manager.impl.UserServiceManagerImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangLongFei 2020-12-26-20:48
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceManagerImpl userServiceManager;

    @GetMapping("/userAdd")
    public boolean userAdd() {
        boolean b = userServiceManager.insterUser();
        return b;
    }

    @GetMapping("/selectUserList")
    public List<User> selectUserList() {
        User user = new User();
        user.setUserPassword("2");
        return userServiceManager.selectUserList(user);
    }

    @Test
    public void test() {
        System.out.println(true & false);
        System.out.println(true && false);
    }


}
