package com.lagou.dao.impl;

import com.lagou.dao.AccountDao;
import com.lagou.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {


    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAll() {

        List<Account> list = null;
        //编写sql
        String sql = "select * from account";
        try {
            // 执行sql
            list = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Account findById(Integer id) {

        Account query = null;
        // 编写sql
        String sql = "select * from account where id = ?";

        try {
             query = queryRunner.query(sql, new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    public void save(Account account) {

        String sql = "insert into account values(null,?,?)";
        try {
            queryRunner.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Account account) {

        String sql = "update account set name = ?,money = ? where id = ?";
        try {
            queryRunner.update(sql,account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Integer id) {

        String sql = "delete from account where id = ?";
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
