package com.teacher.core.user.service.impl;

import com.teacher.core.user.dao.UserDao;
import com.teacher.core.user.model.User;
import com.teacher.core.user.service.UserService;
import com.teacher.util.FormatJudgeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author:chenxiaohui
 * @Description:
 * @Date:Create in 19:58 2017/12/13
 * @Modified By:
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Override
    public Long createUser(User user) {
        try {

            if (user.getUsername()!=null){
                FormatJudgeUtil.inValidUserName(user.getUsername());
            }
            if (user.getPhone()!=null){
                FormatJudgeUtil.isMobile(user.getPhone().toString());
            }
           Long id=userDao.insertUser(user);
            logger.info("create user..."+id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUserbyid(Long id) {
        User user =null;
        try {
            user = userDao.getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
