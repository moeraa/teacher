package com.teacher.core.user.service.impl;

import com.teacher.core.user.dao.UserDao;
import com.teacher.core.user.model.User;
import com.teacher.core.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author:chenxiaohui
 * @Description:
 * @Date:Create in 19:58 2017/12/13
 * @Modified By:
 */

public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Override
    public Long createUser(User user) {
        try {
            userDao.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
