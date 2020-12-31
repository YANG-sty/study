package com.sys.yang.controller;

import com.sys.yang.pojo.Product;
import com.sys.yang.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * sentinel 分组调试接口
 *
 * @author yangLongFei 2020-12-31-11:22
 */
@RestController
@RequestMapping("/sentinelProduct")
public class SentinelProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/list")
    public List<Product> selectProductList() {
        return productService.selectProductList();
    }

}
