package www.lagou.app;/*
 * @Author 白沙
 * @create 2021/3/13 0013 20:50
 */

import www.lagou.dao.PhoneDao;
import www.lagou.entity.Phone;

import java.sql.SQLException;
import java.util.List;

public class TestTwo {
    public static void main(String[] args) {
        try {
            PhoneDao phoneDao =new PhoneDao();
             phoneDao.findPhoneByPrice(2000,"2019");
             phoneDao.findPhoneByColor("白色");
            System.out.println("价格在2000元以上，生产日期在2019年以前的手机如下：");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
