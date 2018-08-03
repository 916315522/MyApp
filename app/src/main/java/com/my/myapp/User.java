package com.my.myapp;

public class User {
    private int id;
    private String username;
    private String userpwd;
    //获取和保存id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //获取和保存用户名
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    //获取和保存密码
    public String getUserpwd() {
        return userpwd;
    }
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}
