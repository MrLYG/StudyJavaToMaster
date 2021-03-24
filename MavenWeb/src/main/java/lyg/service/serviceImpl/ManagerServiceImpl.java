package lyg.service.serviceImpl;

import lyg.dao.ManagerDao;
import lyg.dao.ManagerDaoImpl;
import lyg.enetity.Manager;
import lyg.factory.EntityFactory;
import lyg.service.ManagerService;

import java.sql.SQLException;

/**
 * @author 李沅罡
 */
public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao;

    public ManagerServiceImpl() {
        this.managerDao = EntityFactory.getManagerDao();
    }

    @Override
    public Manager login(Manager m) {
        Manager resM = null;
        try {
            resM = managerDao.login(m);
            System.out.println(resM);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(resM.getmUsername().equalsIgnoreCase(null)){
            return null;
        }
        return resM;
    }
}
