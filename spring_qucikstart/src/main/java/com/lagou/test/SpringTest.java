package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.servlet.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {

    @Test
    public void test1(){

        // 获取到了spring上下文对象，借助上下文对象可以获取到IOC容器中的bean对象 ,加载的同时就创建了bean对象存到容器中
         ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //ApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("D:\\spring_code\\spring_quickstart\\src\\main\\resources\\applicationContext.xml");

        // 使用上下文对象从IOC容器中获取到了bean对象
        // 1.根据beanid在容器中找对应的bean对象
        //IUserDao userDao = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

        // 2.根据类型在容器中进行查询：有可能报错的情况：根据当前类型匹配到多个实例
        IUserDao userDao = classPathXmlApplicationContext.getBean("userDao",IUserDao.class);

        // 调用方法
        userDao.save();


    }

    @Test
    public void test2(){

        // 核心接口，不会创建bean对象存到容器中
        BeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        //getBean的时候才真正创建bean对象
        IUserDao userDao = (IUserDao) xmlBeanFactory.getBean("userDao");

        userDao.save();


    }



    /*
        测试scope属性：singleton效果
     */
    @Test
    public void test3(){


        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        IUserDao userDao = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

        IUserDao userDao2 = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

        System.out.println(userDao);

        System.out.println(userDao2);

    }


    /*
        测试scope属性：prototype效果
     */
    @Test
    public void test4(){


        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        IUserDao userDao = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

        IUserDao userDao2 = (IUserDao) classPathXmlApplicationContext.getBean("userDao");

        System.out.println(userDao);

        System.out.println(userDao2);

        classPathXmlApplicationContext.close();

    }


    @Test
    public void test5(){

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = (IUserService) classPathXmlApplicationContext.getBean("userService");
        userService.save();

    }



}
