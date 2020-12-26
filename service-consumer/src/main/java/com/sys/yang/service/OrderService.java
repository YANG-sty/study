package com.sys.yang.service;

import com.sys.yang.pojo.Order;
import com.sys.yang.pojo.Product;

import java.util.List;

/**
 * @author yangLongFei 2020-12-25-19:16
 */
public interface OrderService {
    Order selectOrderById(Integer id);
}
