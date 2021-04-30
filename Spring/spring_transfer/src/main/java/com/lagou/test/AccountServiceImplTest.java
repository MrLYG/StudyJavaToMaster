package com.lagou.test;

import com.lagou.proxy.CglibProxyFactory;
import com.lagou.proxy.JDKProxyFactory;
import com.lagou.servlet.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JDKProxyFactory proxyFactory;


    @Test
    public void testTransfer(){

        accountService.transfer("tom","jerry",100d);
    }








    /*
        测试JDK动态代理优化转账案例
     */
    @Test
    public void testTransferProxyJDK(){

        // 当前返回的实际上是AccountService的代理对象proxy
        AccountService accountSericeJDKProxy = proxyFactory.createAccountSericeJDKProxy();
        // 代理对象proxy调用接口中的任意方法时，都会执行底层的invoke方法
        //accountSericeJDKProxy.transfer("tom","jerry",100d);
        accountSericeJDKProxy.save();


    }

    @Autowired
    private CglibProxyFactory cglibProxyFactory;

    /*
       测试Cglib动态代理优化转账案例
    */
    @Test
    public void testTransferProxyCglib(){

        // accountServiceCglibProxy: proxy
        AccountService accountServiceCglibProxy = cglibProxyFactory.createAccountServiceCglibProxy();
        accountServiceCglibProxy.transfer("tom","jerry",100d);

    }


}
