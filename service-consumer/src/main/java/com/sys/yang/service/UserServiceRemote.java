package com.sys.yang.service;

import com.sys.yang.domain.User;

/**
 * @author yangLongFei 2020-12-26-20:39
 */
public interface UserServiceRemote {
    /**
     * 新增用户
     */
    boolean insertUser(String user);
}
