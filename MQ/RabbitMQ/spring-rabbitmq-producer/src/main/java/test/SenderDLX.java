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
public class SenderDLX {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-rabbitmq-producer-dlx.xml");
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
//        rabbitTemplate.convertAndSend("dlx_ttl", "超时，关闭订单".getBytes());

        rabbitTemplate.convertAndSend("dlx_max", "测试长度1".getBytes());
//        rabbitTemplate.convertAndSend("dlx_max", "测试长度2".getBytes());
//        rabbitTemplate.convertAndSend("dlx_max", "测试长度3".getBytes());

        System.out.println("消息已发出...");

        context.close();
    }
}
