package com.sys.yang.controller;

import com.sys.yang.manager.ProductServiceManager;
import com.sys.yang.pojo.Order;
import com.sys.yang.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangLongFei 2020-12-25-19:21
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ProductServiceManager productServiceManager;

    @Value("${yang.provide.name}")
    private String name;

    @GetMapping("/{id}")
    public Order selectProductList(@PathVariable("id") Integer id) {
        System.out.println(name);
        return orderService.selectOrderById(id);
    }

    /**
     * Feign 远程调用方式
     */
    @GetMapping("/remote/{idRemote}")
    public Order selectProductListRemote(@PathVariable("idRemote") Integer id) {
        return productServiceManager.selectOrderById(id);
    }


}
