package com.sys.yang.standard;

import org.springframework.stereotype.Service;

/**
 * @author yangLongFei 2020-12-24-15:48
 */
public class OrderManagerSet {

    private OrderServiceImpl orderService;

    /**
     * 有参构造器
     */
    public OrderManagerSet(OrderServiceImpl orderService) {
        System.out.println("有参构造器，com.sys.yang.standard.OrderManagerSet.OrderManagerSet(com.sys.yang.standard.OrderServiceImpl)");
        this.orderService = orderService;
    }

    /**
     * 无参构造器
     */
    public OrderManagerSet() {
        System.out.println("无参构造器， com.sys.yang.standard.OrderManagerSet.OrderManagerSet()");
    }

    /**
     * set 方法
     */
    public void setOrderService(OrderServiceImpl orderService) {
        System.out.println("set方法 com.sys.yang.standard.OrderManagerSet.setOrderService");
        this.orderService = orderService;
    }

    public void getOrder() {
        orderService.getOrder();
        System.out.println("this is com.sys.yang.standard.OrderManagerSet");
    }

}
