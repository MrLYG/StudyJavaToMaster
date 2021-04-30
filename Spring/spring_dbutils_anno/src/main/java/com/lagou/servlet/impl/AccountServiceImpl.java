package com.lagou.servlet.impl;

import com.lagou.dao.AccountDao;
import com.lagou.domain.Account;
import com.lagou.servlet.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("accountService")  //相当于配置了bean标签  id属性
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao aDao;


    public List<Account> findAll() {

        return  aDao.findAll();
    }

    public Account findById(Integer id) {

        return aDao.findById(id);
    }

    public void save(Account account) {

        aDao.save(account);

    }

    public void update(Account account) {

        aDao.update(account);

    }

    public void delete(Integer id) {

        aDao.delete(id);

    }
}
