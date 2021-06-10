package util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @BelongsProject: lagou-rabbitmq
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-10 14:19
 * @Description: 专门与RabbitMQ获得连接
 */
public class ConnectionUtil {
    public static Connection getConnection() throws  Exception{
        //1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2.在工厂对象中设置MQ的连接信息（ip,port,vhost,username,password）
        factory.setHost("192.168.233.148");
        factory.setPort(5672);
        factory.setVirtualHost("/lagou");
        factory.setUsername("lyg");
        factory.setPassword("123456");
        //3.通过工厂获得与MQ的连接
        Connection connection = factory.newConnection();
        return connection;
    }

    public static void main(String[] args) throws  Exception{
        Connection connection = getConnection();
        System.out.println("connection = " + connection);
        connection.close();;
    }
}
