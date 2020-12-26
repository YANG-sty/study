package com.sys.yang.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sys.yang.domain.User;

/**
 * Create by yang_zzu on 2020/4/14 on 21:21
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过直接sql进行查询操作
     */
    User queryByName(String name);
}
