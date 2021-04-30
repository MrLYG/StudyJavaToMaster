package com.lagou.test;

import com.lagou.config.SpringConfig;
import com.lagou.domain.Account;
import com.lagou.servlet.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //@RunWith指定junit的运行环境  SpringJUnit4ClassRunner是spring提供的作为junit运行环境的类
// @ContextConfiguration({"classpath:applicationContext.xml"})
@ContextConfiguration(classes = {SpringConfig.class})
public class AccountServiceTest {

    //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
   // AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");

    // 当前改成了纯注解形式
/*    AnnotationConfigApplicationContext annotationConfigApplicationContext =   new AnnotationConfigApplicationContext(SpringConfig.class);
    AccountService accountService = (AccountService) annotationConfigApplicationContext.getBean("accountService");*/

    @Autowired
    private AccountService accountService;


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
