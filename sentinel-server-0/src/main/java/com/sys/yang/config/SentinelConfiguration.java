package com.sys.yang.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.common.reflection.qual.GetConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 *
 */
@Configuration
public class SentinelConfiguration {
    //静态代码块会在依赖注入后自动执行,并优先执行
    static{
        System.out.println("---static--");
    }

    /**
     *  @Postcontruct’在依赖注入完成后自动调用
     *  todo 该方法在 授权规则配置完成后，无法正常进入
     */
    @PostConstruct
    public void init(){
        WebCallbackManager.setRequestOriginParser(new RequestOriginParser() {
            @Override
            public String parseOrigin(HttpServletRequest httpServletRequest) {
                String serviceName = httpServletRequest.getParameter("serviceName");
                StringBuffer url = httpServletRequest.getRequestURL();
                if (url.toString().endsWith("favicon.ico")) {
                    // 浏览器会向后台请求favicon.ico图标
                    return serviceName + "  favicon.ico";
                }

                if (StringUtils.isEmpty(serviceName)) {
                    throw new IllegalArgumentException("serviceName must not be null");
                }
                return serviceName + "   " + UUID.randomUUID();
            }
        });

    }
}