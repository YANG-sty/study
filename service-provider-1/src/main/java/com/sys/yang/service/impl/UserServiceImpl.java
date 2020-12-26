package com.sys.yang.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sys.yang.dao.UserMapper;
import com.sys.yang.domain.User;
import com.sys.yang.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangLongFei 2020-12-26-19:28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUser(User user) {
        boolean insert = this.insert(user);
        if (user.getId().equals("2020")) {
            int i = 1 / 0;
        }
        return insert;
    }

}
