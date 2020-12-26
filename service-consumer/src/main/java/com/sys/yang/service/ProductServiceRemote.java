package com.sys.yang.service;

import com.sys.yang.pojo.Product;

import java.util.List;

/**
 * @author yangLongFei 2020-12-26-14:47
 */
public interface ProductServiceRemote {
    List<Product> selectProductList();
}
