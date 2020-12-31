package com.sys.yang.config.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关路由配置类
 *
 * @author yangLongFei 2020-12-29-15:11
 */
@Configuration
public class GateWayRoutesConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder) {
        System.out.println(".......................自定义过滤器.......................");
        return locatorBuilder.routes().route(route ->
                route
                        //断言
                        .path("/product1/**")
                        //目标 url, 路由到微服务地址
                        .uri("lb://service-provider")
                        //注册自定义网关过滤器
                        .filters(new CustomGatewayFilter())
                        // 路由唯一id
//                        .id("product-service-custom-filter"))
                        .id("product-service"))
                .build();
    }

}
