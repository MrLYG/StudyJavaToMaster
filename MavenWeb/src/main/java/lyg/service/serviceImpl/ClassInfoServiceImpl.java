package lyg.service.serviceImpl;

import lyg.dao.ClassInfoDao;
import lyg.enetity.ClassInfo;
import lyg.factory.EntityFactory;
import lyg.service.ClassInfoService;

import java.sql.SQLException;
import java.util.List;

public class ClassInfoServiceImpl  implements ClassInfoService {
    private ClassInfoDao classInfoDao = null;

    public ClassInfoServiceImpl() {
        this.classInfoDao = EntityFactory.getClassInfoDao();
    }

    @Override
    public List<ClassInfo> getClassInfoByPage(String pageNo) {

        try {
            return classInfoDao.getClassInfoByPage(pageNo);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCountofClass() {
        return classInfoDao.getCountofClass();
    }

    @Override
    public Boolean add(ClassInfo classInfo) {
        return classInfoDao.add(classInfo);
    }

    @Override
    public Boolean delete(ClassInfo classInfo) {
        return classInfoDao.delete(classInfo);
    }

    @Override
    public List<ClassInfo> searchclassInfos(ClassInfo classInfo) {
        return classInfoDao.searchclassInfos(classInfo);
    }

    @Override
    public Boolean isHaveForeignClass(ClassInfo classInfo1) {
        return classInfoDao.isHaveForeignClass(classInfo1);
    }
}
