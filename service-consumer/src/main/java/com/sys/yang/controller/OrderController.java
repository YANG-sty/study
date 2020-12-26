package com.sys.yang.controller;

import com.sys.yang.pojo.Order;
import com.sys.yang.pojo.Product;
import com.sys.yang.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangLongFei 2020-12-25-19:21
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/{id}")
    public Order selectProductList(@PathVariable("id") Integer id) {
        return orderService.selectOrderById(id);
    }

}
