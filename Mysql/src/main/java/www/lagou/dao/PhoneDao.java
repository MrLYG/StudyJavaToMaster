package www.lagou.dao;/*
 * @Author 白沙
 * @create 2021/3/13 0013 20:33
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import www.lagou.entity.Phone;
import www.lagou.utils.DruidUtils;

import java.sql.SQLException;
import java.util.List;

public class PhoneDao {
    public void findPhoneByPrice(double price, String prodate) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from phone where price > ? and year(prodate) < ?";
        List<Phone> phoneList = qr.query(sql, new BeanListHandler<Phone>(Phone.class), price, prodate);
        System.out.println("价格在2000元以上，生产日期在2019年以前的手机如下：");
        for (Phone phone: phoneList) {
            System.out.println(phone);
        }
    }
    public void findPhoneByColor(String color) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from phone where color = ?";
        List<Phone> phoneList = qr.query(sql, new BeanListHandler<Phone>(Phone.class), color);
        System.out.println("白颜色的手机如下：");
        for (Phone phone: phoneList) {
            System.out.println(phone);
        }
    }
}
