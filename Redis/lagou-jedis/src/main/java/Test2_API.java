import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: lagou-jedis
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-05 16:23
 * @Description: 常用的API
 */
public class Test2_API {
    Jedis jedis = new Jedis("192.168.233.148",6379);
    private void testString(){
        Jedis jedis = new Jedis("192.168.204.141",6379);

        // string
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");

        Set<String> set = jedis.keys("*");
        Iterator<String> iterator = set.iterator();
        for (set.iterator();iterator.hasNext();){
            String k = iterator.next();
            System.out.println(k+"->"+jedis.get(k));
        }
        Boolean k2Exists = jedis.exists("k2"); // 查看k2是否存在
        System.out.println("k2Exists = " + k2Exists);
        System.out.println( jedis.ttl("k1") );// 查看k1的过期时间

        jedis.mset("k4","v4","k5","v5");
        System.out.println( jedis.mget("k1","k2","k3","k4","k5") );
        System.out.println("--------------------------------------------------------");

    }

    private void testList(){
        Jedis jedis = new Jedis("192.168.204.141",6379);
        // list
        jedis.lpush("list01", "l1","l2","l3","l4","l5");
        List<String> list01 = jedis.lrange("list01", 0, -1);
        for(String s : list01){
            System.out.println(s);
        }
        System.out.println("--------------------------------------------------------");
    }

    private void testSet(){
        Jedis jedis = new Jedis("192.168.204.141",6379);

        // set
        jedis.sadd("order","jd001");
        jedis.sadd("order","jd002");
        jedis.sadd("order","jd003");
        Set<String> order = jedis.smembers("order");
        Iterator<String> order_iterator = order.iterator();
        while(order_iterator.hasNext()){
            String s = order_iterator.next();
            System.out.println(s);
        }
        jedis.srem("order", "jd002");
        System.out.println( jedis.smembers("order").size() );
    }

    private void testHash(){
        Jedis jedis = new Jedis("192.168.204.141",6379);
        jedis.hset("user1", "username","james");
        System.out.println( jedis.hget("user1", "username") );

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("username", "tom");
        map.put("gender", "boy");
        map.put("address", "beijing");
        map.put("phone", "13590875543");

        jedis.hmset("user2", map);
        List<String> list = jedis.hmget("user2", "username", "phone");
        for(String s: list){
            System.out.println(s);
        }
    }

    private void testZset(){

        jedis.zadd("zset01", 60d, "zs1");
        jedis.zadd("zset01", 70d, "zs23");
        jedis.zadd("zset01", 80d, "zs3");
        jedis.zadd("zset01", 90d, "zs4");
        Set<String> zset01 = jedis.zrange("zset01", 0, -1);
        Iterator<String> iterator = zset01.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
        new Test2_API().testZset();
    }
}
