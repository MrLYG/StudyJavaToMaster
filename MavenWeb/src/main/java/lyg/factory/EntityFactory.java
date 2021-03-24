package lyg.factory;

import lyg.dao.ManagerDao;
import lyg.dao.ManagerDaoImpl;
import lyg.dao.StudentDao;
import lyg.dao.StudentDaoImpl;
import lyg.service.ManagerService;
import lyg.service.StudentService;
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
}
