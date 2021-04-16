package com.sys.yang.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @author yangLongFei 2021-04-12-11:20
 */
public final class FallBackException {
    public static void getUserExceptionFallBack(BlockException ex) {
        System.out.println("getUserExceptionFallBack   " + UUID.randomUUID() + "-------------- this is FallBackException.class");
    }
}
