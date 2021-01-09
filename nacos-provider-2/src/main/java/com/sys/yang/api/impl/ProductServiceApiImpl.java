package com.sys.yang.api.impl;

import com.sys.yang.api.ProductServiceApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangLongFei 2021-01-08-20:34
 */
@RestController
public class ProductServiceApiImpl implements ProductServiceApi {
    @Override
    public String getProduct(String name) {
        return "nacos-provider-2 : " + name;
    }

    @Override
    public String detailProduct(Long id) {
        return "id : " + String.valueOf(id);
    }

}
