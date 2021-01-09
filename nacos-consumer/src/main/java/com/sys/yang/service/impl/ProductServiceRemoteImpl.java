package com.sys.yang.service.impl;

import com.sys.yang.remote.product.ProductServiceClint;
import com.sys.yang.service.ProductServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangLongFei 2021-01-08-21:24
 */
@Service
public class ProductServiceRemoteImpl implements ProductServiceRemote {

    @Autowired
    private ProductServiceClint productServiceClint;

    @Override
    public String getProduct(String name) {
        return productServiceClint.getProduct(name);
    }

}
