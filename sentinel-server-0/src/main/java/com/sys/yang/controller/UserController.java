package com.sys.yang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sys.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.UUID;

/**
 * @author yangLongFei 2021-04-12-14:58
 */
@RestController
@RequestMapping("/sentinel/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 限流操作正常执行
     * http://localhost:1010/sentinel/user/getUser?id=100
     */
    @GetMapping("/getUser")
    public String getUser(@PathParam("id") String id) {
        i++;
        /*if (i % 3 == 0) {
            throw new RuntimeException("异常测试");
        } else {
            return userService.getUser(id);
        }*/
        return userService.getUser(id);
    }

    private int i = 0;
    @GetMapping("/getUserException")
    public String getUserException(@PathParam("id") String id) {
        i++;
        if (i % 5 == 0) {
            userService.getUserException(id);
            throw new RuntimeException("测试异常"+i);
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        } else {
            System.out.println(i);
            throw new RuntimeException("测试异常"+i);
        }
//        return "success!!";
    }


    @GetMapping("/fallBackUser")
    public String fallBackUser(@PathParam("id") String id) {
        i++;
        /*if (i % 2 == 0) {
            throw new RuntimeException("测试异常 " + " falBackUser  " + id + "  " + UUID.randomUUID());
        }*/
        String s = userService.fallBackUser(id, i);
        return s;
    }

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    /**
     * 动态更新，nacos 配置文件发生修改，能够实时看到
     */
    @GetMapping("/getCommonName")
    public String getCommonName() {
        return applicationContext.getEnvironment().getProperty("common.name");
    }


    @GetMapping("/paramFlow")
    public String paramFlow(@PathParam("id") String id) {
        i++;
        String s = userService.paramFlow(id, i);
        return s;
    }

    @GetMapping("/authority")
    @SentinelResource(value = "authority")
    public String authority(@PathParam("serviceName") String serviceName) {
        return serviceName;
    }

}
