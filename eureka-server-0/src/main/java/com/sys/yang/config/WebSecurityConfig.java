package com.sys.yang.config;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全认证配置类
 *
 * @author yangLongFei 2020-12-25-16:20
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 忽略 /eureka/** 的所有请求
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 访问 Eureka 控制台 和 /actuator 时能做安全控制
        super.configure(http);
        // 忽略 /eureka/** 的所有请求
        http.csrf().ignoringAntMatchers("/eureka/**");
    }

    /**
     * 保证密码验证的同时，禁用 CSRF 防御机制
     * 方法二 ，直接禁用 CSRF
     */
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }*/
}
