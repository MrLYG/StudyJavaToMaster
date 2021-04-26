package com.lagou.test;

import com.lagou.domain.Account;
import com.lagou.servlet.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");




    //测试添加
    @Test
    public void testSave(){

        Account account = new Account();
        account.setName("lucy");
        account.setMoney(888d);
        accountService.save(account);

    }

    //测试查询
    @Test
    public void testFindById(){
        Account account = accountService.findById(3);
        System.out.println(account);

    }


    //测试查询所有
    @Test
    public void testFindAll(){
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        classPathXmlApplicationContext.close();
    }

    //测试更新
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(3);
        account.setName("jack");
        account.setMoney(2000d);

        accountService.update(account);
    }

    //测试删除
    @Test
    public void testDelete(){
        accountService.delete(3);
    }





}
