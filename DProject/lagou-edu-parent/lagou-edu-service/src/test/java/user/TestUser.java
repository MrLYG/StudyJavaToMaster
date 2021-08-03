package user;

import com.lagou.entity.User;
import com.lagou.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: lagou-edu
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-07 17:59
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-*.xml" })
public class TestUser {

    @Autowired
    private UserService userService;
    
    @Test
    public void login(){
//        User user = userService.login("110", "123");
//        System.out.println("user = " + user);
    }

    @Test
    public void checkPhone(){
//        Integer i = userService.checkPhone("110");
//        System.out.println("i = " + i); //0：未注册 ， 1：已注册
    }
}
