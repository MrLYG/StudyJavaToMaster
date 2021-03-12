package work.www.lagou.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import work.www.lagou.entity.Account;
import work.www.lagou.utils.DruidUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDao {
    public Account findAccountByCard(String card) throws ClassNotFoundException, SQLException {
        Connection con = DruidUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select balance from account where card = ?";
        Account queryAccount = queryRunner.query(con, sql, new BeanHandler<Account>((Class<Account>) Class.forName("work.www.lagou.entity.Account")), card);

        return queryAccount;
    }

    public Boolean transaction(String srcCard, String targetCard , String money) throws SQLException {
        Connection con = DruidUtil.getConnection();
        //2.开启事务
        con.setAutoCommit(false);

        QueryRunner queryRunner = new QueryRunner();
        String sql = "update account set balance = balance - ? where card = ? ";
        queryRunner.update(con,sql, new String[]{money, srcCard});

        String sql2 = "update account set balance = balance + ? where card = ? ";
        queryRunner.update(con,sql2, new String[]{money, targetCard});

        con.commit();
        return true;
    }
}
