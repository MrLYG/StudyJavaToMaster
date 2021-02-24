package lagou.phase1.module2.reflection;

public class TestClassCreate {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是:"+person.name);

        //方式一，通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二，通过forname获得
        Class c2 = Class.forName("lagou.phase1.module2.reflection.Student");   //需要抛出ClassNotFoundException异常
        System.out.println(c2.hashCode());

        //方式三，通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四，基本内置类型的包装类都有一个TYPE属性
        Class c4 = Integer.TYPE;
        System.out.println(c4.getName());

        //获得父类类型
        Class c1Fatehr = c1.getSuperclass();
        System.out.println(c1Fatehr);
    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{

    public Student(){
        this.name = "学生";
    }

}
class Teacher extends Person{
    public Teacher(){
        this.name = "教师";
    }
}