package com.sys.yang.service;

import com.sys.yang.domain.User;

import java.util.List;

/**
 * @author yangLongFei 2020-12-26-19:23
 */
public interface UserService  {

    boolean insertUser(User user);

    List<User> selectUserList(User user);
}
