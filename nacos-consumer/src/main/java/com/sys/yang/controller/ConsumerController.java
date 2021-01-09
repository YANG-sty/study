package com.sys.yang.controller;

import com.sys.yang.service.ProductServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangLongFei 2021-01-08-21:41
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ProductServiceRemote remote;

    /**
     * http://localhost:8890/consumer/get/1223
     * 获得结果是：
     * nacos-provider-1 : 1223
     * nacos-provider-2 : 1223
     * ribbon 采用的是轮询的方式，所以，两个服务是轮询的进行访问
     * 引入jar包，只是为了使用 服务提供者的 接口类的访问路径，
     * 实际进行访问的时候，是通过 nacos 获得服务名称的列表，通过ip：端口/路径 进行访问，和jar包没有关系
     */
    @GetMapping("/get/{name}")
    String getProduct(@PathVariable String name) {
        return remote.getProduct(name);
    }
}
