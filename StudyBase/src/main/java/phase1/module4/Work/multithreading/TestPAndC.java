package phase1.module4.Work.multithreading;


public class TestPAndC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Customer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer synContainer;

    public Productor(SynContainer synContainer){
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了+"+i+"只鸡");
        }
    }
}



//消费者
class Customer extends Thread{
    SynContainer synContainer;

    public Customer(SynContainer synContainer){
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int id = synContainer.pop().getId();
            System.out.println("消费了-->"+id+"只鸡");
        }
    }
}

//产品
class Chicken{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chicken(int i) {
        this.id = i;

    }
}
//缓冲区
class SynContainer{
    //containerSize
    Chicken[] chickens = new Chicken[10];
    //containerCount
    int count = 0;

    //producter put products
    public synchronized void push(Chicken chicken){
        //if container is full, wait customer to custom
        if(count == chickens.length){
            //notify customer to custom, and notify producter wait;
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        chickens[count] = chicken;
        count++;

        //可以通知消费者消费了
        this.notifyAll();
    }
    //customer custom products
    public synchronized Chicken pop(){
        //判断能否消费
        if (count == 0) {
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果可以消费
        count -- ;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }


}
