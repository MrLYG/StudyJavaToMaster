import redis.clients.jedis.Jedis;

/**
 * @BelongsProject: lagou-jedis
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-05 17:54
 * @Description: 测试jedis连接池
 */
public class Test_JedisPool {
    public static void main(String[] args) {
        Jedis jedis1 = JedisPoolUtil.getJedis();
        Jedis jedis2 = JedisPoolUtil.getJedis();

        System.out.println(jedis1==jedis2);
    }
}
