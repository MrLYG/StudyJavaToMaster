package lyg.dao;

import lyg.enetity.Manager;
import lyg.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 李沅罡
 */
public class ManagerDaoImpl implements ManagerDao {


    @Override
    public Manager login(Manager m) throws ClassNotFoundException, SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "select m_id as mid ,m_password as mPassword ,m_username as mUsername,level as mLevel from managers where m_username = ? and m_password = ?";
        Manager query = queryRunner.query(sql, new BeanHandler<>((Class<Manager>) Class.forName("lyg.enetity.Manager")), m.getmUsername(), m.getmPassword());
        if(null != query){
            return query;
        }
        return null;

    }
}
