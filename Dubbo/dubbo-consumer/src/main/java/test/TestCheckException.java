package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @BelongsProject: dubbo-consumer
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 14:05
 * @Description: 启动时检查
 */
public class TestCheckException {
    public static void main(String[] args) throws IOException {
        // 初始化spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");

        System.in.read();
    }
}
