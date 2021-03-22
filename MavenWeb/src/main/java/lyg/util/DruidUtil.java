package lyg.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 李沅罡
 */
public class DruidUtil {
    public static DataSource dataSource;
    static {
        try {
            Properties p = new Properties();

            InputStream inputStream = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");

            p.load(inputStream);

            dataSource = DruidDataSourceFactory.createDataSource(p);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接的方法
    public static Connection getConnection(){

        try {

            return dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取Druid连接池对象的方法
    public static DataSource getDataSource(){
        return dataSource;
    }


    //释放资源
    public static void close(Connection con, Statement statement){

        if(con != null && statement != null){
            try {
                statement.close();
                //归还连接
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Connection con, Statement statement, ResultSet resultSet){

        if(con != null && statement != null && resultSet != null){
            try {
                resultSet.close();
                statement.close();
                //归还连接
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
