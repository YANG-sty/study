package com.sys.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = "com.sys.yang")
//@EnableEurekaClient // 当前版本如果配置了 Eureka 注册中心，默认会开启注解
//@EnableFeignClients // 启动 Feign
//@MapperScan("com.sys.yang.dao")
class GetWayApplication0 {

    public static void main(String[] args) {
        SpringApplication.run(GetWayApplication0.class, args);
    }

}