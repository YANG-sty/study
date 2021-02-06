package com.sys.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = "com.sys.yang")
//@EnableEurekaClient // 当前版本如果配置了 Eureka 注册中心，默认会开启注解
@EnableFeignClients // 启动 Feign
@MapperScan("com.sys.yang.dao")
public class ProviderApplicationService1 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplicationService1.class, args);
    }

}