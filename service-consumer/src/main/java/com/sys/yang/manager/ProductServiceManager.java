package com.sys.yang.manager;

import com.sys.yang.pojo.Order;

/**
 * @author yangLongFei 2020-12-26-14:54
 */
public interface ProductServiceManager {
    Order selectOrderById(Integer id);
}
