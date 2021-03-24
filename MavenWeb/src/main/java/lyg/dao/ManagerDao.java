package lyg.dao;

import lyg.enetity.Manager;

import java.sql.SQLException;

public interface ManagerDao {
    Manager login(Manager m) throws ClassNotFoundException, SQLException;
}
