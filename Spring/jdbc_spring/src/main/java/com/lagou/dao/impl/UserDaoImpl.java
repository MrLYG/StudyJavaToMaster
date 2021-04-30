package com.lagou.dao.impl;

import com.lagou.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

    public void save() {
        System.out.println("dao被调用了，保存成功...");
    }
}
