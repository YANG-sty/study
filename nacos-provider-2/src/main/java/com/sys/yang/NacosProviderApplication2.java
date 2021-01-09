package com.sys.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangLongFei 2021-01-08-20:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication2.class, args);
    }
}
