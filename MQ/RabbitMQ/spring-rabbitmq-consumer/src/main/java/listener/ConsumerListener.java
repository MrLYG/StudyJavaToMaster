package listener;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.listener.adapter.AbstractAdaptableMessageListener;
import org.springframework.stereotype.Component;


/**
 * @BelongsProject: spring-rabbitmq-consumer
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-11 18:42
 * @Description: 消费者监听队列
 */
@Component
public class ConsumerListener extends AbstractAdaptableMessageListener {

    // jackson提供序列化和反序列中使用最多的类，用来转换json的
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
//             S 队列中获取：【"+name+"的邮箱是:"+email+"】");

            //手动确认消息(参数1，参数2)
            /*
            参数1：RabbitMQ想该channel投递的这条消息的唯一标识ID，此ID是一个单调递增的正整数
            参数2：为了减少网络流量，手动确认可以被批量处理，当该参数为true时，则可以一次性确认小于等于msgId值的所有消息
             */


//            String str = new String(message.getBody());
//            System.out.println("str = " + str);
//
//            long msgId = message.getMessageProperties().getDeliveryTag();
//            channel.basicAck(msgId , true);
//            Thread.sleep(3000);
//            System.out.println("休息3秒后，再继续接收消息！");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
