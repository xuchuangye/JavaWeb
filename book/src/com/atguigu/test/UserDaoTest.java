package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import static org.junit.Assert.*;
import org.junit.Test;

public class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin","admin") == null) {
            System.out.println("用户名或者密码错误！登录失败！");
        } else {
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {

        System.out.println(userDao.saveUser(new User(null, "wsg123", "123456", "wsg123@168.com")));

    }
}