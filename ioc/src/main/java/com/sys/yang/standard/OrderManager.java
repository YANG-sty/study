package com.sys.yang.standard;

/**
 * @author yangLongFei 2020-12-24-15:21
 */
public class OrderManager {

    public OrderManager() {
        System.out.println(" 构造 com.sys.yang.standard.OrderManager.OrderManager ");
    }

    OrderService orderService = new OrderServiceImpl();

    public void getOrder() {
        orderService.getOrder();
        System.out.println("i am com.sys.yang.standard.OrderManager.getOrder");
    }
}
