package phase1.module4.Work.reflect;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ConstructorTest {
    public static void main(String[] args) throws Exception {
        Class c1 = Class.forName("phase1.module4.teach.reflect.Person");
        //System.out.println("无参方式创建的对象是：" + c1.newInstance()); // null 0
        // 获取Class对象对应类中的无参构造方法，也就是Person类中的无参构造方法
        Constructor constructor = c1.getConstructor();
        // 使用获取到的无参构造方法来构造对应类型的对象，也就是Person类型的对象
        System.out.println("无参方式创建的对象是：" + constructor.newInstance());


        //有参数构造"无参方式创建的对象是：" + constructor.newInstance()

        Constructor constructor1 = c1.getConstructor(String.class,int.class);
        System.out.println("无参方式创建的对象是：" + constructor1.newInstance("lyg",20));


        Constructor[] cs = c1.getConstructors();
        for (Constructor ct: cs ) {
            System.out.println("构造方法的访问修饰符是：" + ct.getModifiers());
            System.out.println("构造方法的方法名称是：" + ct.getName());
            Class[] parameterTypes = ct.getParameterTypes();
            System.out.print("构造方法的所有参数类型是：");
            for (Class clzz : parameterTypes) {
                System.out.print(clzz + " ");
            }
            System.out.println();
            System.out.println("-------------------------------------------------");

        }
    }

}
