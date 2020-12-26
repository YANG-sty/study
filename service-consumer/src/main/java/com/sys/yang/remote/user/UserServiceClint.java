package com.sys.yang.remote.user;

import com.sys.yang.api.UserServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author yangLongFei 2020-12-26-20:38
 */
@FeignClient(value = "${yang.provide.name}")
public interface UserServiceClint extends UserServiceApi {
}
