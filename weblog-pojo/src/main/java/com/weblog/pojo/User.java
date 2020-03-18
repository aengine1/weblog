package com.weblog.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private Integer userId;

    private String userName;

    private String userPwd;

    //角色
    private Roles roles;

    //权限
    private List<Perimission> permission;


    public List<Perimission> getPermission() {
        return permission;
    }

    public void setPermission(List<Perimission> permission) {
        this.permission = permission;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }
}