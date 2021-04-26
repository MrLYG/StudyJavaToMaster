package com.lagou.servlet;

import com.lagou.domain.Account;

import java.util.List;

public interface AccountService {


    public List<Account> findAll();

    public Account findById(Integer id);

    public void save(Account account);

    public void update(Account account);

    public void delete(Integer id);



}
