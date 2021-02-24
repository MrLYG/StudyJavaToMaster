package lagou.phase1.module2.reflection;

public class WhatIsReflection {
    public static void main(String[] args) throws ClassNotFoundException{
        Class c1 = Class.forName("lagou.phase1.module2.reflection.User");
        System.out.println(c1);

        Class c2 = Class.forName("lagou.phase1.module2.reflection.User");
        Class c3 = Class.forName("lagou.phase1.module2.reflection.User");
        Class c4 = Class.forName("lagou.phase1.module2.reflection.User");
        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都会封装在class对象中
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }
}

class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


