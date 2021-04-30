package com.lagou.proxy;

import com.lagou.servlet.AccountService;
import com.lagou.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/*
    该类就是采用cglib动态代理来对目标类（AccountServiceImpl）进行方法（transfer）的动态增强（添加上事务控制）
 */
@Component
public class CglibProxyFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    public AccountService createAccountServiceCglibProxy(){
        // 编写cglib对应的API来生成代理对象进行返回
        // 参数1 ： 目标类的字节码对象
        // 参数2：  动作类，当代理对象调用目标对象中原方法时，那么会执行intercept方法
        AccountService accountServiceproxy = (AccountService) Enhancer.create(accountService.getClass(), new MethodInterceptor() {

            // o ： 代表生成的代理对象   method：调用目标方法的引用  objects：方法入参    methodProxy：代理方法
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                try {
                    // 手动开启事务：调用事务管理器类中的开启事务方法
                    transactionManager.beginTransaction();

                    method.invoke(accountService, objects);

                    transactionManager.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    // 手动回滚事务
                    transactionManager.rollback();
                } finally {
                    // 手动释放资源
                    transactionManager.release();
                }


                return null;
            }
        });
        return accountServiceproxy;


    }



}
