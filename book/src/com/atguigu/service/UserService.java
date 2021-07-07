package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {

    /**
     * 注册用户信息
     * @param user 用户
     */
    public void registerUser(User user);

    /**
     * 用户输入用户名和密码进行登录
     * @param user 用户名
     * @return 返回null，登录失败。返回其他，登录成功。
     */
    public User login(User user);

    /**
     *
     * @param username 用户名
     * @return 返回true，表示用户已存在，返回false，表示用户名可用
     */
    public boolean existsUsername(String username);
}
