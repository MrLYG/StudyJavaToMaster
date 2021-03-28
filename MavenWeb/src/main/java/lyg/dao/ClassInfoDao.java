package lyg.dao;

import lyg.enetity.ClassInfo;

import java.sql.SQLException;
import java.util.List;

public interface ClassInfoDao {
    List<ClassInfo> getClassInfoByPage(String pageNo) throws ClassNotFoundException, SQLException;

    int getCountofClass();

    Boolean add(ClassInfo classInfo);

    Boolean delete(ClassInfo classInfo);

    List<ClassInfo> searchclassInfos(ClassInfo classInfo);

    Boolean isHaveForeignClass(ClassInfo classInfo1);
}
