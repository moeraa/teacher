package com.teacher.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.api.client.json.Json;
import com.teacher.core.user.model.User;
import com.teacher.core.user.service.UserService;
import com.teacher.util.PubUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Author:chenxiaohui
 * @Description:
 * @Date:Create in 10:21 2018/1/22
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void userList(@RequestParam(required = true,value = "user_id") Long uid,
                         HttpServletResponse httpServletResponse){
        User user = userService.getUserbyid(uid);
        JSONObject resultObj = new JSONObject();
        if (user!=null){
            resultObj.put("User",JSON.toJSON(user));
            logger.info("user", JSON.toJSON(user));
        }else {
            resultObj.put("User","user is null");
        }

        resultObj.put("code","success");
        resultObj.put("message","moer is a pretty girl");
        try {
            PubUtil.responseText(httpServletResponse,resultObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void userCreate(@RequestParam(required = true,value = "username") String username,
                           @RequestParam(required = true,value = "password") String password,
                           @RequestParam(required = true,value = "usersex") Integer usersex,
                           @RequestParam(required = false,value = "phone") Long phone,
                           @RequestParam(required = false,value = "status") Integer status,
                           @RequestParam(required = false,value = "usersignatrue") String usersignatrue,
                           @RequestParam(required = false,value = "idNum") Long idNum,  //状态  用户状态：激活1、已删除-1
                           @RequestParam(required = true,value = "userslug") String userslug,

                         HttpServletResponse httpServletResponse){

        User user =new User();
        user.setUsername(username);
        user.setSex(usersex);
        user.setPassword(password);
        user.setPhone(phone);
        user.setStatus(status);
        user.setUserphoto(null);
        user.setUsersignatrue(usersignatrue);
        user.setUserSlug(userslug);
        user.setIdNum(idNum);
        user.setCtime(new Timestamp(System.currentTimeMillis()));
        Long uid = userService.createUser(user);
        JSONObject resultObj = new JSONObject();
        if (uid!=null){
            resultObj.put("User","ok");
        }else {
            resultObj.put("User","user is null");
        }

        resultObj.put("code","success");
        resultObj.put("message","moer is a pretty girl");
        try {
            PubUtil.responseText(httpServletResponse,resultObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
