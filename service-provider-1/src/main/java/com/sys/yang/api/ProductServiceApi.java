package com.sys.yang.api;

import com.sys.yang.pojo.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 对外提供的接口
 * @author yangLongFei 2020-12-26-14:17
 */
@RequestMapping("/productApi")
public interface ProductServiceApi {

    @GetMapping("/list")
    List<Product> selectProductList();
}
