package phase1.module4.Work.multithreading;

public class stopTest implements Runnable{
    private boolean flag = true;


    @Override
    public void run() {
        int i =0;
        while (flag){
            System.out.println("run.....thread" + i++);
        }
    }

    public void stop(){
        flag = false;
    }


    public static void main(String[] args) throws InterruptedException {
        stopTest s = new stopTest();
        new Thread(s).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main...."+i);
            if(i == 900){
                s.stop();
                System.out.println("线程停止了！");
            }
        }
    }
}
