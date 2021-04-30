package com.lagou.test;

import com.lagou.service.IUserService;
import com.lagou.service.impl.UserServiceImpl;
import org.junit.Test;

public class SpringTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        // 获取业务层对象
        IUserService userService = new UserServiceImpl();

        // 调用save方法
        userService.save();


    }



}
