package com.sys.yang.api;

import org.springframework.web.bind.annotation.*;

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
