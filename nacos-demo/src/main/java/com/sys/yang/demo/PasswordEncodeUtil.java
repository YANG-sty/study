package com.sys.yang.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yangLongFei 2021-01-04-21:09
 */
public class PasswordEncodeUtil {
    // 加密
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

//    INSERT INTO users (username, password, enabled) VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', TRUE);

//    INSERT INTO roles (username, role) VALUES ('nacos', 'ROLE_ADMIN');

}
