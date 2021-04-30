package com.lagou.servlet;

public interface AccountService {

    // 转账方法
    public void transfer(String outUser,String inUser,Double money);

    public void save();

    public void update();

    public void delete();








}
