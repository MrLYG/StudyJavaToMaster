package stub;

import org.springframework.util.StringUtils;
import service.HelloService;

/**
 * @BelongsProject: dubbo-consumer
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 15:07
 * @Description: 本地存根
 */
public class HelloServiceStub implements HelloService {

    private HelloService helloService; //helloService的代理对象

    // 本地存根必须以构造方法的形式注入
    public HelloServiceStub(HelloService helloService) {
        this.helloService = helloService;
    }

    public String sayHello(String name) {
        if(!StringUtils.isEmpty(name)){
            return helloService.sayHello(name);
        }
        return "i am sorry!";
    }

    public String sayNo() {
        return helloService.sayNo();
    }
}
