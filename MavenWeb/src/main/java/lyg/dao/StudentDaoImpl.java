package lyg.dao;

import lyg.enetity.Student;
import lyg.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 李沅罡
 */
public class StudentDaoImpl implements StudentDao{
    @Override
    public List<Student> getAllStudents() {
        try {
//            private String sId;
//            private String sName;
//            private String sGender;
//            private String sBorn;
//            private String sEmail;
//            private String sPassword;
//            private String sNote;
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "select s_id as sId ,s_name as sName ,s_gender as sGender ,s_born as sBorn ," +
                         "s_email as sEmail ,s_password as sPassword ,note as sNote from student ";

            List<Student> query = queryRunner.query(sql, new BeanListHandler<>((Class<Student>) Class.forName("lyg.enetity.Student")));
            return query;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean revise(Student s) {
        try {
//            private String sId;
//            private String sName;
//            private String sGender;
//            private String sBorn;
//            private String sEmail;
//            private String sPassword;
//            private String sNote;
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "update student set s_id = ?, s_name = ?, s_gender = ?, s_born = ?, s_email = ? where s_id = ?  ";
            Object[] params = {s.getsId(),s.getsName(),s.getsGender(),s.getsBorn(),s.getsEmail(),s.getsId()};
            int update = queryRunner.update(sql, params);
            if(update>=1){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean add(Student s) {
        try {
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "insert into student (s_name, s_gender, s_born, s_email)values(?,?,?,?) ";
            Object[] params = {s.getsName(),s.getsGender(),s.getsBorn(),s.getsEmail()};
            int update = queryRunner.update(sql, params);
            if(update>=1){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> searchStudent(Student s) {
        try {

            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "select s_id as sId ,s_name as sName ,s_gender as sGender ,s_born as sBorn ," +
                    "s_email as sEmail ,s_password as sPassword ,note as sNote from student where s_name = ? ";

            List<Student> query = queryRunner.query(sql, new BeanListHandler<>((Class<Student>) Class.forName("lyg.enetity.Student")),s.getsName());
            return query;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean delete(Student s) {
        try {
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "delete from student where s_id = ? ";
            int update = queryRunner.update(sql, s.getsId());
            if(update>=1){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
