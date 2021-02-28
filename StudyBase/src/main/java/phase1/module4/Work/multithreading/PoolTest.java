package phase1.module4.Work.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTest {
    public static void main(String[] args) {
        Runnable r = ()->{
            System.out.println(Thread.currentThread().getName());
        };
        //创建服务，创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //执行
        service.execute(r);
        service.execute(r);
        service.execute(r);
        service.execute(r);

        //关闭连接
        service.shutdown();
    }
}
