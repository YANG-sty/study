package com.sys.yang.manager;

import com.sys.yang.domain.User;

import java.util.List;

/**
 * @author yangLongFei 2020-12-26-20:42
 */
public interface UserServiceManager {
    boolean insterUser();

    List<User> selectUserList(User user);
}
