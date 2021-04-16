package com.sys.yang.service;

/**
 * @author yangLongFei 2021-04-12-11:05
 */
public interface UserService {
    String getUser(String id);

    void getUserException(String id);

    String fallBackUser(String id, int i);

    String paramFlow(String id, int i);
}
