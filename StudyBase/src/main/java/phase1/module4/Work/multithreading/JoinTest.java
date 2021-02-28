package phase1.module4.Work.multithreading;

public class JoinTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println(Thread.currentThread().getName()+"......."+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest j = new JoinTest();
        Thread t = new Thread(j);
        t.start();
        for (int i = 0; i < 2000; i++) {
            if(i == 1000){
                t.join();
            }
            System.out.println("main Thread..."+i);
        }
    }
}
