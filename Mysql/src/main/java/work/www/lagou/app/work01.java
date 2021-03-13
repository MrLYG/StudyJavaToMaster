package work.www.lagou.app;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import work.www.lagou.dao.AccountDao;
import work.www.lagou.entity.Account;
import work.www.lagou.utils.DruidUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class work01 {

    private static AccountDao accountDao = new AccountDao();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //通过Druid数据库连接池创建连接

        System.out.println("------------------------转账模拟--------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您自己的卡号");
        String srcCardNo = sc.next();
        System.out.println("请输入转账的卡号");
        String targetCardNo = sc.next();
        System.out.println("请输入转账金额");
        int money = sc.nextInt();

        //判断账户余额是否充足
        if(accountDao.findAccountByCard(srcCardNo).getBalance()< money){
            System.out.println("账户余额不足");
            return;
        }

        //进行转账
        Boolean f = accountDao.transaction(srcCardNo,targetCardNo,String.valueOf(money));
        if (f) {
            System.out.println("转账成功");

        }


    }
}
