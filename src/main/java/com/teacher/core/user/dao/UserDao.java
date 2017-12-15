package com.teacher.core.user.dao;

import com.teacher.core.user.model.User;

/**
 * @Author:chenxiaohui
 * @Description:
 * @Date:Create in 11:00 2017/12/13
 * @Modified By:
 */
public interface UserDao {

    Long insertUser(User user)throws Exception;
    User getUser(Long id)throws Exception;
    User getUserBySlug(String slug)throws Exception;
    void updateUser(User user)throws Exception;



}
