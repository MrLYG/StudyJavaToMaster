package per.lyg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.lyg.domain.Employee;
import per.lyg.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Employee> findAll(){
        List<Employee> employees = employeeService.findAll();
        System.out.println(employees);
        return employees;
    }

    @RequestMapping("/addEmployee")
    @ResponseBody
    public String addEmployee(Employee e){
        String s = employeeService.addEmployee(e);
        System.out.println(s);
        return s;
    }

}
