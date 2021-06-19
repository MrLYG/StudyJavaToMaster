package controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: lagou-killreids
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-06 11:57
 * @Description: 测试秒杀
 */
@Controller
public class TestKill {

    @Autowired
    private Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("kill")
    // 只能解决一个tomcat的并发问题：synchronized锁的一个进程下的线程并发，如果分布式环境，多个进程并发，这种方案就失效了！
    public @ResponseBody synchronized String kill() {

        // 定义商品id
        String productKey = "HUAWEI-P40";
        // 通过redisson获取锁
        RLock rLock = redisson.getLock(productKey); // 底层源码就是集成了setnx，过期时间等操作
        // 上锁（过期时间为30秒）
        rLock.lock(30, TimeUnit.SECONDS);

        try{
        // 1.从redis中获取 手机的库存数量
        int phoneCount = Integer.parseInt(stringRedisTemplate.opsForValue().get("phone"));
        // 2.判断手机的数量是否够秒杀的
        if (phoneCount > 0) {
            phoneCount--;
            // 库存减少后，再将库存的值保存回redis
            stringRedisTemplate.opsForValue().set("phone", phoneCount + "");
            System.out.println("库存-1，剩余：" + phoneCount);
        } else {
            System.out.println("库存不足！");
        }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 释放锁
            rLock.unlock();
        }
        return "over!";
    }


    @Bean
    public Redisson redisson(){
        Config config = new Config();
        // 使用单个redis服务器
        config.useSingleServer().setAddress("redis://192.168.204.141:6379").setDatabase(0);
        // 使用集群redis
        // config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://192.168.204.141:6379","redis://192.168.204.142:6379","redis://192.168.204.143:6379");
        return (Redisson)Redisson.create(config);
    }
}