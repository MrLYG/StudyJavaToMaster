package com.lagou.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.lagou")
@EnableAspectJAutoProxy //开启AOP的自动代理 替代了<aop:aspectj-autoproxy>
public class SpringConfig {
}
