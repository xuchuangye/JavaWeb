package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回null表示该用户名不存在，返回user对象表示该用户存在
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 返回null表示该用户名或者密码错误，返回User表示登录成功
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user User的实例
     * @return 返回-1表示失败，返回其他表示成功
     */
    public int saveUser(User user);
}
