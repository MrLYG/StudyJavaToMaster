package com.lagou.test;

import com.lagou.config.SpringConfig;
import com.lagou.servlet.AccountSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:applicationContext.xml"})
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceImplTest {

    @Autowired
    private AccountSerivce accountSerivce;

    @Test
    public void testTransfer(){
        accountSerivce.transfer("tom","jerry",100d);
    }


}
