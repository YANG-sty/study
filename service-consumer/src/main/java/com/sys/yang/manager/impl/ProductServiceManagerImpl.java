package com.sys.yang.manager.impl;

import com.sys.yang.manager.ProductServiceManager;
import com.sys.yang.pojo.Order;
import com.sys.yang.service.impl.ProductServiceRemoteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangLongFei 2020-12-26-14:52
 */
@Service
public class ProductServiceManagerImpl implements ProductServiceManager {
    @Autowired
    private ProductServiceRemoteImpl productServiceRemote;

    @Override
    public Order selectOrderById(Integer id) {
        return new Order(id, "order-999", "zhengzhou", 58000D, productServiceRemote.selectProductList());
    }

}
