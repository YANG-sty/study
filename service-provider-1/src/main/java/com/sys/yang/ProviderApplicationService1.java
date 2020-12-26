package com.sys.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
//@EnableEurekaClient // 当前版本如果配置了 Eureka 注册中心，默认会开启注解
class ProviderApplicationService1 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplicationService1.class);
    }

}