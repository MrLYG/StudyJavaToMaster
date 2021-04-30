package com.lagou.dao;

import com.lagou.domain.Account;

import java.util.List;

public interface AccountDao {

    /*
        查询所有账户
     */
    public List<Account> findAll();

    /*
        根据ID查询账户
     */
    public Account findById(Integer id);

    /*
        添加账户
     */
    public void save(Account account);

    /*
        更新账户信息
     */
    public void update(Account account);

    /*
        根据ID删除账户
     */
    public void delete(Integer id);


}
