package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import per.lyg.domain.Dept;
import per.lyg.service.DeptService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DpetDaoTest {

    @Autowired
    private DeptService deptService;
    @Test
    public void testFindAll(){

        List<Dept> all = deptService.findAll();
        for (Dept account : all) {
            System.out.println(account);
        }

    }
}
