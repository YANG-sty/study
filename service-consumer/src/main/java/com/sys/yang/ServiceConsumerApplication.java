package com.sys.yang;

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
@SpringBootApplication
//@EnableEurekaClient // 当前版本如果配置了 Eureka 注册中心，默认会开启注解
@EnableFeignClients(basePackages = {"com.sys"})
public class ServiceConsumerApplication {

    // 手动注入 RestTemplate
    @Bean
//    @LoadBalanced // 负载均衡器
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 全局配置，通过Bean 在启动类 进行注入
     * 随机策略 RandomRule
     */
    @Bean
    public RandomRule randomRule() {
        return new RandomRule();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class, args);
    }

}