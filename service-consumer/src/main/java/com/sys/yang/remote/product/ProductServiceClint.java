package com.sys.yang.remote.product;

import com.sys.yang.api.ProductServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author yangLongFei 2020-12-26-14:31
 */
@FeignClient(value = "${yang.provide.name}")
public interface ProductServiceClint extends ProductServiceApi {
}
