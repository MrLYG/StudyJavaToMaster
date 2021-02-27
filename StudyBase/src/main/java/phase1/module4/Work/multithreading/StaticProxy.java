package phase1.module4.Work.multithreading;

interface date{
    void date();
}

public class StaticProxy {
    public static void main(String[] args) {
        new Restaurant(new Person() ).date();
    }
}

class Person implements date{

    @Override
    public void date() {
        System.out.println("认真吃饭");
    }
}

class Restaurant implements date{
    private Person t;

    public Restaurant(Person t) {
        this.t = t;
    }

    @Override
    public void date() {
        before();
        t.date();
        after();
    }

    private void after() {
        System.out.println("饭后-饭店收费");
    }

    private void before() {
        System.out.println("饭前-饭店安排隐私");
    }
}


