package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import static org.junit.Assert.*;
import org.junit.Test;

public class UserServiceTest {
    private UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"gej618","666666","gej168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "admin", "admin@atguigu.com")));
    }

    @Test
    public void existsUsername() {
        boolean isExists = userService.existsUsername("wsg168");
        if (isExists) {
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名不存在，可以使用！");
        }
    }
}