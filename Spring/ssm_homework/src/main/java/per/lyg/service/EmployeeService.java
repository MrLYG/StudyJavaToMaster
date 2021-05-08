package per.lyg.service;

import per.lyg.domain.Employee;

import java.util.List;

/**
 * @author hp
 */
public interface EmployeeService {
    public List<Employee> findAll();
    public String addEmployee(Employee e);
}
