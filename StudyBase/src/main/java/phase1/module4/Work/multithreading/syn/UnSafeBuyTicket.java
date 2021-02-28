package phase1.module4.Work.multithreading.syn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"苦逼的你").start();
        new Thread(station,"牛逼的我").start();
        new Thread(station,"可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable{
    //票
    private int ticketNums = 10;
    private Lock lock = new ReentrantLock();
    boolean flag = true;

    @Override
    public  void run() {
        //buy ticket
        while (flag) {
            try {
                lock.lock();
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();

            }finally {
                lock.unlock();
            }
        }
    }

    private /*synchronized*/ void buy() throws InterruptedException {

        //判断是否有票
        if(ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        //卖票
        System.out.println(Thread.currentThread().getName()+"get"+ticketNums--);

    }
}