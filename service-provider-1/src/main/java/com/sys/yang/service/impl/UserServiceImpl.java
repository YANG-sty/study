package com.sys.yang.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sys.yang.dao.UserMapper;
import com.sys.yang.domain.User;
import com.sys.yang.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<User> selectUserList(User user) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.like(StringUtils.isNotBlank(user.getUserName()), "user_name", user.getUserName());
        entityWrapper.like(StringUtils.isNotBlank(user.getUserPassword()), "user_password", user.getUserPassword());
        return this.selectList(entityWrapper);
    }
}
