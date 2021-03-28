package lyg.factory;

import lyg.dao.*;
import lyg.service.ClassInfoService;
import lyg.service.ManagerService;
import lyg.service.StudentService;
import lyg.service.serviceImpl.ClassInfoServiceImpl;
import lyg.service.serviceImpl.ManagerServiceImpl;
import lyg.service.serviceImpl.StudentServiceImpl;

/**
 * @author 李沅罡
 */
public class EntityFactory {
    public static ManagerDao getManagerDao(){
        return new ManagerDaoImpl();
    }
    public static ManagerService getManagerService(){
        return new ManagerServiceImpl();
    }
    public static StudentService getStudentService(){
        return new StudentServiceImpl();
    }
    public static StudentDao getStudentDao(){
        return new StudentDaoImpl();
    }
    public static ClassInfoService getClassInfoService(){ return  new ClassInfoServiceImpl();
    }
    public static ClassInfoDao getClassInfoDao(){ return  new ClassInfoDaoImpl();
    }
}
