package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.HelloService;


/**
 * @BelongsProject: dubbo-consumer
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-23 18:09
 * @Description: 控制层
 */
@Controller
public class HelloAction {

    //@Reference  // 远程去服务方将service的实现类注入进来
    @Autowired
    private HelloService helloService;

    @GetMapping("hello")
    @ResponseBody
    public String sayHi(String name){
        return helloService.sayHello(name);
    }

    @GetMapping("no")
    @ResponseBody
    public String no(){
        return helloService.sayNo();
    }
}
