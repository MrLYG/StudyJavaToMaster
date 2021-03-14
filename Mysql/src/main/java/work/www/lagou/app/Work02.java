package work.www.lagou.app;

import work.www.lagou.dao.PhoneDao;
import work.www.lagou.entity.Phone;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author 李沅罡
 */
public class Work02 {
    private static PhoneDao phoneDao = new PhoneDao();
    public static void main(String[] args) throws SQLException {
        /**+
         * 需求1:  查询价格高于2000元，生产日期是2019年之前的所有手机
         */
        List l = phoneDao.findPhoneByPriceAndProdate(2000,"2019");

        System.out.println(l);

        /**
         * 需求2:  查询所有颜色是白色的手机信息
         */

        List l2 = phoneDao.findPhoneByColor("白色");
        System.out.println(l2);
    }

}
