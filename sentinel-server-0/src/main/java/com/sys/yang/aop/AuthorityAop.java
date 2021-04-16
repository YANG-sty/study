package com.sys.yang.aop;

import com.alibaba.csp.sentinel.context.ContextUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yangLongFei 2021-04-16-11:09
 */
@Aspect
@Component
public class AuthorityAop {

    @Value("${}")

    @Pointcut(value = "execution(* com.sys.*.controller.*(*))")
    private void cutPoint() {
    }

    @Before("cutPoint()")
    public String authorityAspect(JoinPoint joinPoint) {

        return "abcd" +
                "";
    }
}
