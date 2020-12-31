package com.sys.yang.config.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 * @author yangLongFei 2020-12-29-15:51
 */
@Component
public class GlobalGatewayFilter implements GlobalFilter, Ordered {
    /**
     * 过滤器业务逻辑
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(" ？？？？？？？？？？？？？？自定义全局过滤器 ？？？？？？？？？？？？？？");
        //继续向下执行
        return chain.filter(exchange);
    }

    /**
     * 过滤器执行顺序，数值越小，优先级越高
     */
    @Override
    public int getOrder() {
        return -1;
    }

}
