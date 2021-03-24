import lyg.enetity.Manager;
import lyg.enetity.Student;
import lyg.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;



import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DaoTest {
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
////        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
//////        Manager query = queryRunner.query(sql, new BeanHandler<>((Class<Manager>) Class.forName("lyg.enetity.Manager")), "admin", "123456");
////        Connection con = DruidUtil.getConnection();
////        PreparedStatement preparedStatement = con.prepareStatement("select * from managers where m_username = ? and m_password = ?");
////        preparedStatement.setString(1,"admin");
////        preparedStatement.setString(2,"123456");
////        ResultSet resultSet = preparedStatement.executeQuery();
////        Manager m = new Manager();
////        while (resultSet.next()){
////            m.setmId(resultSet.getString("m_id"));
////            m.setmPassword(resultSet.getString("m_password"));
////            m.setmUsername(resultSet.getString("m_username"));
////            m.setmLevel(resultSet.getString("level"));
////        }
////        System.out.println(m);
//        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
//        String sql = "select m_id as mid ,m_password as mPassword ,m_username as mUsername,level as mLevel from managers where m_username = ? and m_password = ?";
//        Manager query = queryRunner.query(sql, new BeanHandler<Manager>((Class<Manager>) Class.forName("lyg.enetity.Manager")), "admin", "123456");
//        if(null != query){
//            System.out.println(query);
//        }
////        return null;
//    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "select s_id as sId ,s_name as sName ,s_gender as sGender ,s_born as sBorn ," +
                "s_email as sEmail ,s_password as sPassword ,note as sNote from student ";

        List<Student> query = queryRunner.query(sql, new BeanListHandler<>((Class<Student>) Class.forName("lyg.enetity.Student")));
        System.out.println(query.toString());
    }

}
