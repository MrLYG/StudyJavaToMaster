package per.lyg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.lyg.domain.Employee;
import per.lyg.mapper.EmployeeMapper;
import per.lyg.service.EmployeeService;

import java.util.List;

/**
 * @author hp
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeMapper.findAll();
        return employees;
    }

    @Override
    public String addEmployee(Employee e) {
        int i = employeeMapper.addEmployee(e);
        if (i > 0) {
            return "success";
        }else {
            return "fail";
        }
    }

}
