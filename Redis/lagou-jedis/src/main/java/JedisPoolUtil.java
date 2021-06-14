import jdk.nashorn.internal.scripts.JD;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @BelongsProject: lagou-jedis
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-05 17:46
 * @Description: 单例模式优化jedis连接池
 */
public class JedisPoolUtil {

    private JedisPoolUtil(){}

    private volatile static JedisPool jedisPool = null;
    private volatile static Jedis jedis = null;

    // 返回一个连接池
    private static JedisPool getInstance(){
        // 双层检测锁（企业中用的非常频繁）
        if(jedisPool == null){ // 第一层：检测体温
            synchronized (JedisPoolUtil.class){  // 排队进站
                if(jedisPool == null) { //第二层：查看健康码
                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxTotal(1000);
                    config.setMaxIdle(30);
                    config.setMaxWaitMillis(60*1000);
                    config.setTestOnBorrow(true);
                    jedisPool = new JedisPool( config, "192.168.233.148",6379 );
                }
            }
        }
        return jedisPool;
    }

    // 返回jedis对象
    public static Jedis getJedis(){
        if(jedis == null){
            jedis = getInstance().getResource();
        }
        return jedis;
    }
}
