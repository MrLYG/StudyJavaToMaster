package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring-rabbitmq-consumer
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-11 18:52
 * @Description: 运行项目
 */
public class TestRunner {
    public static void main(String[] args) throws  Exception {
        // 获得容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-rabbitmq-consumer.xml");
        // 让程序一直运行，别终止
        System.in.read();
    }
}
