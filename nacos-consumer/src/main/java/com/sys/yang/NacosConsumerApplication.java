package com.sys.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yangLongFei 2021-01-08-21:13
 */
@SpringBootApplication
@EnableDiscoveryClient //启动注册发现
@EnableFeignClients(basePackages = {"com.sys.yang.remote"}) //远程调用的的接口的文件夹
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }
}
