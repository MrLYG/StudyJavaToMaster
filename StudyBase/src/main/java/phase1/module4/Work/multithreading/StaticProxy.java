package phase1.module4.Work.multithreading;

interface Date{
    void date();
}

public class StaticProxy {
    public static void main(String[] args) {
        new Restaurant(new Person() ).date();
    }
}

class Person implements Date{

    @Override
    public void date() {
        System.out.println("认真吃饭");
    }
}

class Restaurant implements Date{
    private Date d;

    public Restaurant(Date d) {
        this.d = d;
    }

    @Override
    public void date() {
        before();
        d.date();
        after();
    }

    private void after() {
        System.out.println("饭后-饭店收费");
    }

    private void before() {
        System.out.println("饭前-饭店安排隐私");
    }
}


