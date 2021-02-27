package phase1.module4.Work.multithreading;

public class ThreadMulti implements Runnable {

    private static String winner;
    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            if("兔子".equals(Thread.currentThread().getName()) && i%10==0){
                try {
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName()+"睡了1 mills");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"---->跑了"+i+"步");
        }
    }

    //判断比赛是否胜利
    private boolean gameOver(int steps){
        if(null != winner){
            return true;
        }else {
            if (steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is "+ winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreadMulti t1 = new ThreadMulti();
        ThreadMulti t2 = new ThreadMulti();

        new Thread(t1,"兔子").start();
        new Thread(t2,"乌龟").start();
    }
}
