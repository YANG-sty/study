package com.sys.yang.service.impl;

import com.sys.yang.pojo.Product;
import com.sys.yang.service.ProductServcie;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangLongFei 2020-12-25-19:17
 */
@Service
public class ProductServiceImpl implements ProductServcie {
    @Override
    public List<Product> selectProductList() {
        return Arrays.asList(
                new Product(1, "huawei", 2, 2300),
                new Product(2, "oppo", 33, 1300),
                new Product(3, "apple", 22, 4300)
        );
    }

    @Override
    public List<Product> postListProduct() {
        return Arrays.asList(
                new Product(100, "post", 2, 2300),
                new Product(200, "post", 33, 1300),
                new Product(300, "post", 22, 4300)
        );
    }
}
