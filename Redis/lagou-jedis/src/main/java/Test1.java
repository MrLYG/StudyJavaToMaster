import redis.clients.jedis.Jedis;

/**
 * @BelongsProject: lagou-jedis
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-05 16:16
 * @Description: 测试连接redis
 */
public class Test1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.233.148",6379);
        String pong = jedis.ping();
        System.out.println("pong = " + pong);
    }
}
