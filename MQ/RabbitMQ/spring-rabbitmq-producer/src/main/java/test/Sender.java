package test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: spring-rabbitmq-producer
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-11 18:01
 * @Description: 生产者
 */
public class Sender {
    public static void main(String[] args) {
        //1.创建spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-rabbitmq-producer.xml");
        //2.从容器中获得 rabbit模版对象
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        //3.发消息
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "吕布");
        map.put("email", "666@qq.com");
//        for(int i = 1;i<=10;i++) {
            rabbitTemplate.convertAndSend("msg.user", map);
            System.out.println("消息已发出...");
//        }

        context.close();
    }
}
