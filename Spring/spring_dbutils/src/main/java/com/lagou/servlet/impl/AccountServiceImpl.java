package com.lagou.servlet.impl;

import com.lagou.dao.AccountDao;
import com.lagou.domain.Account;
import com.lagou.servlet.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;


@Service("accountService")  //相当于配置了bean标签  id属性
@Scope("singleton")
public class AccountServiceImpl implements AccountService {

/*    @Autowired //根据类型进行注入
    @Qualifier("accountDao")*/
    @Resource(name = "accountDao")
    private AccountDao aDao;

    @Value("注入普通属性")
    private String str;

    @Value("${jdbc.driverClassName}")
    private String driver;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法....");
    }


    @PreDestroy
    public void destory(){
        System.out.println("销毁方法....");
    }



    public List<Account> findAll() {

        System.out.println(str);
        System.out.println(driver);
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
