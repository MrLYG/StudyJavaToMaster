package com.lagou.servlet.impl;

import com.lagou.dao.AccountDao;
import com.lagou.domain.Account;
import com.lagou.servlet.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountSerivceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    public List<Account> findAll() {
        List<Account> all = accountDao.findAll();

        return all;
    }

    public Account findById(Integer id) {
        Account account = accountDao.findById(id);

        return account;
    }

    public void save(Account account) {

        accountDao.save(account);

    }

    public void update(Account account) {

        accountDao.update(account);

    }

    public void delete(Integer id) {

        accountDao.delete(id);

    }
}
