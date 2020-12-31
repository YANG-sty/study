package com.sys.yang.config.rate;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 限流配置（redis 令牌桶）
 * @author yangLongFei 2020-12-30-19:56
 */
@Configuration
public class KeyResolverConfiguration {


    /**
     * 限流规则
     * 访问路径限流
     */
//    @Bean
    public KeyResolver pathKeyResolver() {

        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                System.out.println(exchange.getRequest().getURI().getPath());
                return Mono.just(exchange.getRequest().getURI().getPath());
            }
        };
//        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }


    /**
     * 参数限流
     */
//    @Bean
    public KeyResolver parameterKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                System.out.println(exchange.getRequest().getQueryParams().getFirst("token"));
                return Mono.just(exchange.getRequest().getQueryParams().getFirst("token"));
            }
        };
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("token"));

    }



    /**
     * ip限流
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                System.out.println(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
                return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
            }
        };
//        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());

    }



}
