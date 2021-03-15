package www.lagou.dao;/*
 * @Author 白沙
 * @create 2021/3/13 0013 16:22
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import www.lagou.entity.Account;
import www.lagou.entity.Transaction;
import www.lagou.utils.DateUtils;
import www.lagou.utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TransferAccountsDao {
    /**
    * 转账的方法
    * */
    public void transferAccounts(String carDidOut, String carDidIn){
        //1.获取数据库连接
        Connection con = null;
        try {
            double balanceOut = selectCard(carDidOut);
            if (balanceOut >= 5000) {
                con = DruidUtils.getConnection();
                //手动开启事务
                //con.setAutoCommit(false);
                //获取QueryRunner对象。
                QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
                //编写SQL
                String sqlOut = "UPDATE account SET balance = balance - 5000 WHERE card = ?";
                String sqlIn = "UPDATE account SET balance = balance + 5000 WHERE card = ?";
                //执行SQL
                qr.update(sqlOut, carDidOut);
                qr.update(sqlIn, carDidIn);
                //System.out.println(1 / 0);
                forTransaction(carDidOut, "转出");
                forTransaction(carDidIn, "转入");
                System.out.println("您好，转账成功！");
                System.out.println("--------------------------------------------------");
                System.out.println("转出卡信息如下：");
                System.out.println(selectCardInfo(carDidOut));
                System.out.println("转出卡累计交易记录如下：");
                selectTransaction(carDidOut);
                System.out.println("--------------------------------------------------");
                System.out.println("转入卡信息如下：");
                System.out.println(selectCardInfo(carDidIn));
                System.out.println("转入卡累计交易记录如下：");
                selectTransaction(carDidIn);
            }else {
                System.out.println("您的转出卡余额不足，转账失败");
            }
            //con.commit();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("您好，转账发生错误或者余额不足，转账失败");
            //try {
                //con.rollback();
            /*} catch (SQLException ex) {
                ex.printStackTrace();
            }*/
        } finally {
            if (null != con){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /**
     * 插入交易记录
     * */
    public int forTransaction(String cardId,String traType) throws SQLException {
        //1.获取QueryRunner对象
        QueryRunner qr = new QueryRunner(DruidUtils.dataSource);
        //2.编写SQL
        String sql = "insert into transaction values(?,?,?,?,?)";
        Object[] param = {null,cardId,traType,5000,DateUtils.getDateFormart()};
        //3.执行插入操作
        int update = qr.update(sql, param);
        return update;

    }
    /**
     * 查询累计交易记录方法
     * */
    public void selectTransaction(String cardId) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from transaction where cardid = ?";
        List<Transaction> list = qr.query(sql, new BeanListHandler<Transaction>(Transaction.class), cardId);
        for (Transaction transaction: list) {
            System.out.println("交易卡号：" + transaction.getCarDid() + " 于：" + transaction.getTraDate() + " " + transaction.getTraType() + " :" + transaction.getTraMoney() + " 元");
        }
    }
    /**
    * 获取转账后的账户信息
    * */
    public Account selectCardInfo(String cardId) throws SQLException {
        //1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from account where card = ?";
        Account account = qr.query(sql,new BeanHandler<Account>(Account.class),cardId);
        return account;
    }
    /**
     * 查询转账出的账户余额
    * */
    public double selectCard(String carDidOut) throws SQLException {
        //1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2.编写SQL
        String sql = "select * from account where card = ?";
        //3.执行查询
        Account account = qr.query(sql, new BeanHandler<Account>(Account.class), carDidOut);
        double balance = account.getBalance();
        return balance;
    }


}
