package com.teacher.core.user.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author:chenxiaohui
 * @Description:
 * @Date:Create in 10:40 2017/12/13
 * @Modified By:
 */
@Entity
@Table(name = "my_user")
public class User {
    private Long id;
    @Column(name = "username")
    private String username;//用户名
    @Column(name = "password")
    private String password;//密码
    @Column(name = "usersex")
    private Integer sex;//性别
    @Column(name = "phone")
    private Integer phone;//电话
    @Column(name = "status")
    private Integer status;//状态  用户状态：激活1、已删除-1
    @Column(name = "usersignatrue")
    private Integer usersignatrue; //个性签名
    @Column(name = "idNum")
    private Integer idNum; //身份证号

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUsersignatrue() {
        return usersignatrue;
    }

    public void setUsersignatrue(Integer usersignatrue) {
        this.usersignatrue = usersignatrue;
    }

    public Integer getIdNum() {
        return idNum;
    }

    public void setIdNum(Integer idNum) {
        this.idNum = idNum;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    @Column(name = "userphoto")
    private String userphoto; //图片
    @Column(name = "ctime")
    private Timestamp ctime;//创建时间



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
