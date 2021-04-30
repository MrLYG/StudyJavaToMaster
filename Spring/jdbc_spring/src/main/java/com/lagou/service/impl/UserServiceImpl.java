package com.lagou.service.impl;

import com.lagou.dao.IUserDao;
import com.lagou.service.IUserService;
import com.lagou.utils.BeanFactory;

public class UserServiceImpl implements IUserService {


    public void save() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 调用dao层方法 传统方式 :存在编译期依赖：耦合重
        //IUserDao userDao = new UserDaoImpl();

        //反射
        // IUserDao userDao = (IUserDao) Class.forName("com.lagou.dao.impl.UserDaoImpl").newInstance();

        IUserDao userDao = (IUserDao) BeanFactory.getBean("userDao");
        userDao.save();

    }

}
