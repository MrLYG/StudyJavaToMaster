package phase1.module4.Work.multithreading;

import java.util.List;

public class DeadLock {
    public static void main(String[] args) {
        MakeUp girl1 = new MakeUp(0,"灰姑凉");
        MakeUp girl2 = new MakeUp(1,"白雪公主");
        girl1.start();;
        girl2.start();
    }
}

class LipStick{}

class Mirror{

}

class MakeUp extends Thread{

    private static LipStick lipStick = new LipStick();
    private static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;

    MakeUp(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
      //抱住对方的锁，会照成死锁
//    private void makeup() throws InterruptedException {
//        if(choice == 0){
//            synchronized (lipStick){
//                System.out.println(this.girlName+"获得口红的锁");
//                Thread.sleep(1000);
//                synchronized (mirror){
//                    System.out.println(this.girlName+"获得镜子的锁");
//                }
//            }
//        }else {
//            synchronized (mirror){
//                System.out.println(this.girlName+"获得镜子的锁");
//                Thread.sleep(2000);
//                synchronized (lipStick){
//                    System.out.println(this.girlName+"获得口红的锁");
//                }
//            }
//        }
//    }
      private void makeup() throws InterruptedException {
          if(choice == 0){
              synchronized (lipStick){
                  System.out.println(this.girlName+"获得口红的锁");
                  Thread.sleep(1000);

              }
              synchronized (mirror){
                  System.out.println(this.girlName+"获得镜子的锁");
              }
          }else {
              synchronized (mirror){
                  System.out.println(this.girlName+"获得镜子的锁");
                  Thread.sleep(2000);

              }
              synchronized (lipStick){
                  System.out.println(this.girlName+"获得口红的锁");
              }
          }
      }
}