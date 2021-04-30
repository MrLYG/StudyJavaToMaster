package com.lagou.servlet.impl;

import com.lagou.dao.AccountDao;
import com.lagou.servlet.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;




    /*
        转账方法  切入点   添加上事务控制的效果
     */
    public void transfer(String outUser, String inUser, Double money) {


        // 编写了事务相关代码
        // 调用了减钱方法
        accountDao.out(outUser,money);

        int i= 1/0;

        // 调用了加钱方法
        accountDao.in(inUser,money);



    }

    @Override
    public void save() {
        // 编写了事务相关代码
        System.out.println("save方法");
    }

    @Override
    public void update() {
        System.out.println("update方法");
    }

    @Override
    public void delete() {
        System.out.println("delete方法");
    }


}
