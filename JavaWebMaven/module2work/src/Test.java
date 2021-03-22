
import org.apache.commons.dbutils.QueryRunner;
import per.lyg.util.DruidUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 李沅罡
 */

public class Test {

    public static void main(String[] args) throws SQLException {
        Connection con = DruidUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into student values(?,?,?,?,?,?,?)";
        Object[] params = {"1","1","1","1","1","1","1"};
        queryRunner.update(con,sql,params);
    }
//    public static void main(){
//
//    }

}
