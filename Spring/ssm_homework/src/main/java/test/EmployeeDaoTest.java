package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import per.lyg.domain.Dept;
import per.lyg.domain.Employee;
import per.lyg.mapper.EmployeeMapper;
import per.lyg.service.DeptService;
import per.lyg.service.EmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeDaoTest {
    @Autowired
    private EmployeeService employeeService;
    @Test
    public void testFindAll(){

        List<Employee> all = employeeService.findAll();
        for (Employee e : all) {
            System.out.println(e);
        }

    }

    @Test
    public void testAddEmployee(){
        Employee e = new Employee();
        e.setEmp_name("lyg");
        e.setDept_id(1);
        e.setJob_name("JAVA高级工程师");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse("2021-10-2");
            e.setJoin_date(date);
            e.setTelephone("1369159236");
            String s = employeeService.addEmployee(e);
            System.out.println(s);


        } catch (ParseException x) {
            x.printStackTrace();
        }

    }
}
