package lyg.service.serviceImpl;

import lyg.dao.ManagerDao;
import lyg.dao.ManagerDaoImpl;
import lyg.enetity.Manager;
import lyg.service.ManagerService;

import java.sql.SQLException;

/**
 * @author 李沅罡
 */
public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();
    @Override
    public Boolean login(Manager m) {

        try {
            if(managerDao.login(m)){
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
