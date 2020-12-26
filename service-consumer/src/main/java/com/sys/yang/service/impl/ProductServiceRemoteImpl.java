package com.sys.yang.service.impl;

import com.sys.yang.pojo.Product;
import com.sys.yang.remote.product.ProductServiceClint;
import com.sys.yang.service.ProductServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 在本项目中，进行一次封装
 * @author yangLongFei 2020-12-26-14:47
 */
@Service
public class ProductServiceRemoteImpl implements ProductServiceRemote {

    @Autowired
    private ProductServiceClint productServiceClint;

    @Override
    public List<Product> selectProductList() {
        return productServiceClint.selectProductList();
    }

}
