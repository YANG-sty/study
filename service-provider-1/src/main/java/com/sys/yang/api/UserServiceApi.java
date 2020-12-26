package com.sys.yang.api;

import com.sys.yang.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangLongFei 2020-12-26-19:35
 */
@RequestMapping("/userApi")
public interface UserServiceApi {

    @GetMapping("/userAdd/{user}")
    boolean insertUser(@PathVariable("user") String user);
}
