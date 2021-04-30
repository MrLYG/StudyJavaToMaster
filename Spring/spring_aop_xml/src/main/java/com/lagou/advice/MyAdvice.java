package com.lagou.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/*
    通知类
 */
public class MyAdvice {



    public void before(){
        System.out.println("前置通知执行了....");
    }

    public void afterReturning(){
        System.out.println("后置通知执行了....");
    }


    public void afterThrowing(){

        System.out.println("异常通知执行了....");
    }

    public void after(){
        System.out.println("最终通知执行了....");
    }

    // Proceeding JoinPoint : 正在执行的连接点：切点
    public Object around(ProceedingJoinPoint pjp){

        // 切点方法执行
        Object proceed = null;
        try {
            System.out.println("前置通知执行了");
            proceed = pjp.proceed();
            System.out.println("后置通知执行了");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知执行了");
        }finally {
            System.out.println("最终通知执行了");
        }

        return proceed;
    }



}
