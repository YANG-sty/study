package com.sys.yang.api.impl;

import com.sys.yang.api.ProductServiceApi;
import com.sys.yang.pojo.Product;
import com.sys.yang.service.ProductServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangLongFei 2020-12-26-14:18
 */
@RestController
public class ProductServiceApiImpl implements ProductServiceApi {

    @Autowired
    private ProductServcie productServcie;

    @Override
    public List<Product> selectProductList() {
        return productServcie.selectProductList();
    }
}
