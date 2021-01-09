package com.sys.yang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangLongFei 2021-01-08-20:41
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/get")
    public String getProduct(@RequestParam(value = "id") String id) {
        return "nacos-provider-1 get id : " + id;
    }
}
