package com.sys.yang.config.filter;

import com.google.common.net.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 权限验证过滤器
 * @author yangLongFei 2020-12-29-15:59
 */
@Component
@Slf4j
public class AccessGlobalGatewayFilter implements GlobalFilter, Ordered {
    /**
     * 过滤器业务逻辑
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(" 。。。。。。。。。。。。。。权限验证过滤器 。。。。。。。。。。。。。。");
        //获取请求参数
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        //业务逻辑处理
        if (StringUtils.isEmpty(token)) {
            log.warn(" tokenn is null ........... ");
            ServerHttpResponse response = exchange.getResponse();
            //响应类型
            response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
            //相应转态码， 401 没有权限访问
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //相应内容
            String messge = "{\"message\": \"10000100001000000   "+ HttpStatus.UNAUTHORIZED.getReasonPhrase()+"\" }";
            DataBuffer wrap = response.bufferFactory().wrap(messge.getBytes());
            //请求结束，不执行后面的请求
            return response.writeWith(Mono.just(wrap));
        }
        // 使用token 进行身份验证
        log.info("token is ok ! ");
        log.info("value : " + token);

        //继续向下执行
        return chain.filter(exchange);
    }

    /**
     * 过滤器执行顺序，数值越小，优先级越高
     */
    @Override
    public int getOrder() {
        return 3;
    }
}
