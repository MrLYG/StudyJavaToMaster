package com.lagou.servlet.impl;

import com.lagou.servlet.AccountService;

public class AccountServiceImpl implements AccountService {

    /*
        目标方法：（切入点：要进行拦截增强的方法）
    */
    public void transfer() {

        System.out.println("转账方法执行了....");
        //int i = 1/0;
    }
}
