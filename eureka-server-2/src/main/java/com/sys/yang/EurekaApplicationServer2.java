package com.sys.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 */
@EnableEurekaServer
@SpringBootApplication
class EurekaApplicationServer2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationServer2.class);
    }

}