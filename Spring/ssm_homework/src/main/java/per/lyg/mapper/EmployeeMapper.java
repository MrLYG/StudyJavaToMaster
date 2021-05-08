package per.lyg.mapper;

import org.apache.ibatis.annotations.Select;
import per.lyg.domain.Employee;

import java.util.List;

/**
 * @author hp
 */
public interface EmployeeMapper {


    public List<Employee> findAll();

    public int addEmployee(Employee e);
}
