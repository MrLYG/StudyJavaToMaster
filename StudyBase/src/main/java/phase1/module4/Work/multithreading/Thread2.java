package phase1.module4.Work.multithreading;

public class Thread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("实现Runnable子线程------"+i);
        }
    }

    public static void main(String[] args) {
        Runnable r = new Thread2();
        new Thread(r).start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("------主线程---"+i);
        }
    }
}
