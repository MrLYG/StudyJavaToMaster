package test;

import entity.Users;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: lagou-dubbo
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 17:46
 * @Description: 测试dao层
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class TestDao {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void register(){
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Users user = new Users("a1","1","11",time);
        userMapper.register(user);
        System.out.println("注册成功！");
    }
    @Test
    public void delete(){
        userMapper.deleteUser(1);
        System.out.println("删除成功！");
    }
    @Test
    public void reviseUser(){
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Users user = new Users();
        user.setUid(2);
        user.setCreatetime(time);
        user.setPhone("123");
        userMapper.reviseUser(user);
        System.out.println("修改成功！");
    }

    @Test
    public void findUsersbyName(){
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Users user = new Users();
        user.setUid(2);
        user.setCreatetime(time);
        user.setPhone("123");
        user.setUsername("a");
        List<Users> users = userMapper.findUsersbyName(user);
        System.out.println(users);
        System.out.println("修改成功！");
    }
}
