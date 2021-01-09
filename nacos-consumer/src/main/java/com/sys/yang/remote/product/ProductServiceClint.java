package com.sys.yang.remote.product;

import com.sys.yang.api.ProductServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * value = "${yang.provide.name}" 配置文件中，配置的生产者服务的名称
 */
@FeignClient(value = "${yang.provide.name}")
public interface ProductServiceClint extends ProductServiceApi {

}