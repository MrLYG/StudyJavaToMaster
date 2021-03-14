package work.www.lagou.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import work.www.lagou.entity.Phone;
import work.www.lagou.utils.DruidUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author 李沅罡
 */
public class PhoneDao {
    public List<Phone> findPhoneByPriceAndProdate(double price, String date) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "select * from phone where price > ? and prodate  < ?";
        Object[] o ={price, date};
//        List<Phone> query = queryRunner.query(sql, new BeanListHandler<Phone>(Phone.class), price, date);
//        return query;
        return queryRunner.query(sql, new BeanListHandler<Phone>(Phone.class), price, date);
    }

    public List findPhoneByColor(String c) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "select * from phone where color = ?";
        List<Phone> query = queryRunner.query(sql, new BeanListHandler<Phone>(Phone.class), c);
        return query;
    }
}
