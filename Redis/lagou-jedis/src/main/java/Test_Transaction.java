import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @BelongsProject: lagou-jedis
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-08-05 17:30
 * @Description: 测试事务
 */
public class Test_Transaction {
    public static void main(String[] args) throws  Exception{
        Jedis jedis = new Jedis("192.168.204.141",6379);

        int yue  = Integer.parseInt( jedis.get("yue") );
        int zhichu = 10;

        jedis.watch("yue"); // 监控余额
        Thread.sleep(5000); // 模拟网络延迟

        if(yue < zhichu){
            jedis.unwatch(); //解除监控
            System.out.println("余额不足！");
        }else{
            Transaction transaction = jedis.multi(); // 开启事务
            transaction.decrBy("yue", zhichu);  // 余额减少
            transaction.incrBy("zhichu", zhichu); // 累计消费增加
            transaction.exec();
            System.out.println("余额：" + jedis.get("yue"));
            System.out.println("累计支出：" + jedis.get("zhichu"));
        }
    }
}

