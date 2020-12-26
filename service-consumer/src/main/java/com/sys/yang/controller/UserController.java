package com.sys.yang.controller;

import com.sys.yang.manager.impl.UserServiceManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
