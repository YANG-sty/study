package com.sys.yang.controller;

import com.sys.yang.pojo.Product;
import com.sys.yang.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangLongFei 2020-12-25-19:21
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/list")
    public List<Product> selectProductList() {
        return productService.selectProductList();
    }

    @PostMapping("/postList")
    public List<Product> postListProduct() {
        return productService.postListProduct();
    }

    /**
     * http://172.28.14.55:9000/product/info?id=123&token=abc1
     */
    @RequestMapping("/info")
    public Product info(@RequestParam("id") Integer id) {
        Product product = productService.selectProductList().get(0);
        product.setId(id);
        return product;
    }

    @RequestMapping("/flag")
    public Product flag(Integer flag) {
        Product product = productService.selectProductList().get(0);
        product.setId(flag);
        return product;
    }

}
