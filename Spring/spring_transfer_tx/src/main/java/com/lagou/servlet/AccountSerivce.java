package com.lagou.servlet;

public interface AccountSerivce {

    /*
        转账方法
     */

    public void transfer(String outUser,String inUser,Double money);


}
