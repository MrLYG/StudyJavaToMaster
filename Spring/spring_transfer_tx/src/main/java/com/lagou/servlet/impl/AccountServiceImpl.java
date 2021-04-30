package com.lagou.servlet.impl;

import com.lagou.dao.AccountDao;
import com.lagou.servlet.AccountSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountSerivce {

    @Autowired
    private AccountDao accountDao;


    //@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = -1,readOnly = false)
    public void transfer(String outUser, String inUser, Double money) {

        //调用dao的out及in方法
        accountDao.out(outUser,money);

        int i = 1/0;

        accountDao.in(inUser,money);
    }
}
