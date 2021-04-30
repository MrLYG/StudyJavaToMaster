package com.lagou.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
    通知类
 */
@Component
@Aspect  //升级为切面类：配置切入点和通知的关系
public class MyAdvice {

    @Pointcut("execution(* com.lagou.servlet.impl.AccountServiceImpl.*(..))")
    public void myPoint(){}

    /*@Before("MyAdvice.myPoint()")
    public void before(){
        System.out.println("前置通知执行了....");
    }


    @AfterReturning("MyAdvice.myPoint()")
    public void afterReturning(){
        System.out.println("后置通知执行了....");
    }


    @AfterThrowing("MyAdvice.myPoint()")
    public void afterThrowing(){
        System.out.println("异常通知执行了...");
    }


    @After("MyAdvice.myPoint()")
    public void after(){
        System.out.println("最终通知执行了....");
    }
    */

    @Around("MyAdvice.myPoint()")
    public Object around(ProceedingJoinPoint pjp){

        Object proceed = null;
        try {
            System.out.println("前置通知执行了...");
            proceed = pjp.proceed();
            System.out.println("后置通知执行了...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知执行了...");
        } finally {
            System.out.println("最终通知执行了...");
        }


        return  proceed;
    }







}
