package com.teacher.core.user.service;

import com.teacher.core.user.model.User;
import org.springframework.stereotype.Service;

/**
 * @Author:chenxiaohui
 * @Description:
 * @Date:Create in 19:54 2017/12/13
 * @Modified By:
 */

public interface UserService {
    Long createUser(User user);
    User getUserbyid(Long id);
}
