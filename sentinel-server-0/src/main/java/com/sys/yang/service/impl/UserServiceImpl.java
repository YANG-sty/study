package com.sys.yang.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sys.yang.exception.FallBackException;
import com.sys.yang.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author yangLongFei 2021-04-12-11:08
 */
@Service
public class UserServiceImpl implements UserService {

    public String getUserBlockHandler(String id, BlockException exception) {
        exception.printStackTrace();
        return id + " " + "yang_zzu";
    }

    /**
     * 若未配置 blockHandler、fallback 和 defaultFallback，则被限流降级时会将 BlockException 直接抛出（若方法本身未定义 throws BlockException 则会被 JVM 包装一层 UndeclaredThrowableException）
     * 若 blockHandler 和 fallback 都进行了配置，则被限流降级而抛出 BlockException 时只会进入 blockHandler 处理逻辑
     * 优先级：
     * blockHandler 》fallback 》defaultFallback = fallbackClass（fallbackClass 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析）
     */
    @Override
    @SentinelResource(value = "getUser",
            blockHandler = "getUserBlockHandler", // 限流
            fallback = "sentinel",  // 熔断
            defaultFallback = "",
            exceptionsToIgnore = RuntimeException.class
    )
    public String getUser(String id) {
        return id+" "+ UUID.randomUUID().toString().replace("-","");
    }

    @Override
    @SentinelResource(value = "getUserException",
            blockHandler = "getUserExceptionFallBack", //FallBackException 中的静态方法
            fallbackClass = {FallBackException.class} //fallback 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 fallbackClass 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析。
    )
    public void getUserException(String id) {
        System.out.println("getUserException" + "  " + id + " " + UUID.randomUUID());
    }


    @Override
    @SentinelResource(value = "fallBackUser",
            blockHandler = "getUserBlockHandlerFallBack", //限流
            fallback = "getUserFallBack", defaultFallback = "" //熔断
//            exceptionsToIgnore = RuntimeException.class
    )
    public String fallBackUser(String id, int i) {
        if (i % 2 == 0) {
            throw new RuntimeException("测试异常 " + " falBackUser  " + id + "  " + UUID.randomUUID());
        }
        return "falBackUser  " + id + "  " + UUID.randomUUID();
    }


    @Override
    @SentinelResource(value = "paramFlow",
            blockHandler = "getUserBlockHandlerFallBack", //限流
            fallback = "getUserFallBack", defaultFallback = "" //熔断
    )
    public String paramFlow(String id, int i) {
        return id + "  " + UUID.randomUUID();
    }


    public String getUserFallBack(String id, int i) {
        return id + "  " + i;
    }

    public String getUserBlockHandlerFallBack(String id, int i,BlockException ex) {
        return id + "  " + i + "    getUserBlockHandlerFallBack";
    }




}
