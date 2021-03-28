package lyg.dao;

import lyg.enetity.ClassInfo;
import lyg.enetity.Student;
import lyg.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClassInfoDaoImpl implements ClassInfoDao{
    @Override
    public List<ClassInfo> getClassInfoByPage(String pageNo)  {
        int step = 10;
        int allCount = getCountofClass();
        try {
            Integer start = Integer.parseInt(pageNo)*10-step;
            if(start+10>allCount){
                step = allCount - start ;
            }
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "select class_id as classId ,class_name as className ,grade ,home_teacher_name as homeTeacherName ," +
                    "class_num as classNum ,class_slogan as classSlogan from `classinfo` limit ?,?";

            List<ClassInfo> query = queryRunner.query(sql, new BeanListHandler<ClassInfo>((Class<ClassInfo>) Class.forName("lyg.enetity.ClassInfo")), start, step);


            return query;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCountofClass() {
        try {
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "select count(*) from `classinfo` ";
            Long query = queryRunner.query(sql, new ScalarHandler<>());

            return query.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Boolean add(ClassInfo c) {
        try {
//            select class_id as classId ,class_name as className ,grade ,home_teacher_name as homeTeacherName ," +
//            "class_num as classNum ,class_slogan as classSlogan from `classinfo` limit ?,?";
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "insert into classinfo (class_name, grade, home_teacher_name, class_num, class_slogan)values(?,?,?,?,?) ";
            Object[] params = {c.getClassName(),c.getGrade(),c.getHomeTeacherName(),c.getClassNum(),c.getClassSlogan()};
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
    public Boolean delete(ClassInfo c) {
        try {
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "delete from classinfo where class_id = ? ";
            int update = queryRunner.update(sql, c.getClassId());
            if(update>=1){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ClassInfo> searchclassInfos(ClassInfo classInfo) {
        try {
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "select class_id as classId ,class_name as className ,grade ,home_teacher_name as homeTeacherName ," +
                        "class_num as classNum ,class_slogan as classSlogan from `classinfo` where class_name = ?";
            List<ClassInfo> query = queryRunner.query(sql, new BeanListHandler<ClassInfo>((Class<ClassInfo>) Class.forName("lyg.enetity.ClassInfo")), classInfo.getClassName());
            return query;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean isHaveForeignClass(ClassInfo classInfo1) {
        try {
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "select count(*) from classinfo c , student s where c.class_id = s.class_id and s.class_id = ?";
            Long query = queryRunner.query(sql, new ScalarHandler<>(),classInfo1.getClassId());
            return query>=1?true:false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
