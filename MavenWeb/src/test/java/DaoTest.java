import lyg.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoTest {
    public static void main(String[] args) throws SQLException {
        Connection con = DruidUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into student values(?,?,?,?,?,?,?)";
        Object[] params = {"2","1","1","2001-1-1","1","1","1"};
//        queryRunner.update(con,sql,params);
    }
//    public static void main(){
//
//    }
}
