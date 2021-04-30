package com.lagou.dao;

public interface AccountDao {


    /*
        减钱：转出操作
     */
    public void out(String outUser,Double money);

    /*
       加钱：转入操作
    */
    public void in(String inUser,Double money);

}
