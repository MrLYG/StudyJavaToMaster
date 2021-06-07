package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: lagou-dubbo
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 18:16
 * @Description: 控制层
 */
@RestController
public class UserAction {

    @Reference
    private UserService userService;

    @RequestMapping("/register")
    public String register(Users user) {
        System.out.println("来注册");
        try {
            String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            user.setCreatetime(nowTime);
            userService.register(user);
            return "注册成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }
    @RequestMapping("/delete")
    public String deleteUser(Users user) {
        System.out.println("来删除");
        try {
            userService.deleteUser(user.getUid());
            return "删除成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }
    @RequestMapping("/revise")
    public String reviseUser(Users user) {
        System.out.println("来修改");
        try {
            userService.reviseUser(user);
            return "修改成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }

    @RequestMapping("/findUsersbyName")
    public List<Users> findUsersbyName(String name) {
        Users user = new Users();
        user.setUsername(name);
        System.out.println("来查询");
        try {
            List<Users> list = userService.findUsersbyName(user);
            System.out.println(list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }



}
