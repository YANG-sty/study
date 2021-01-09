package com.sys.yang.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangLongFei 2021-01-08-20:32
 */
@RequestMapping("/productApi")
public interface ProductServiceApi {

    @GetMapping("/getProduct/{name}")
    String getProduct(@PathVariable String name);

    @GetMapping("/detail")
    String detailProduct(@RequestParam(value = "id") Long id);

}
