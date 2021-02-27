package phase1.module4.Work.multithreading;

public class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("子线程------"+i);
        }
    }

    public static void main(String[] args) {
        new Thread1().start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("------主线程---"+i);
        }
    }
}
