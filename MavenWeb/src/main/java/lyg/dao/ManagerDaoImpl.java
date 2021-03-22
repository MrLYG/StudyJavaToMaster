package lyg.dao;

import lyg.enetity.Manager;
import lyg.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 李沅罡
 */
public class ManagerDaoImpl implements ManagerDao {


    @Override
    public Boolean login(Manager m) throws ClassNotFoundException, SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "select * from managers where m_username = ? and m_password = ?";
        List<Manager> query = queryRunner.query(sql, new BeanListHandler<Manager>((Class<Manager>) Class.forName("lyg.enetity.Manager")), m.getmUsername(), m.getmPassword());
        if(query.size()>=1){
            return true;
        }
        return false;
    }
}
