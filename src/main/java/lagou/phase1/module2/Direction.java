package lagou.phase1.module2;

import java.security.PublicKey;
/**
 * java.lang.Enum
 * static T[] values() 返回当前类的对象
 * String toString() 返回当前枚举对象的名称
 * int ordinal()      返回枚举对象在枚举类中的索引位置
 * static T valueOf(String str) 将参数的字符串名转换为当前枚举类的对象
 * int compareTo(E o) 比较两个枚举对象在定义时的顺序
 */
//java5 枚举类型要求所有枚举值必须放在枚举类型的最前面
//枚举值就是当前对象类型
public enum  Direction implements DirectionInterface{
    //    public static final Direction UP = new Direction("向上");
    //    new Direction("向上"){ }
    UP("向上"){
        @Override
        public void show() {
            System.out.println("XX向上移动");
        }
    }, DOWN("向下") {
        @Override
        public void show() {
            System.out.println("XX向下移动");
        }
    }, LEFT("向左") {
        @Override
        public void show() {
            System.out.println("XX向左移动");
        }
    }, RIGHT("向右") {
        @Override
        public void show() {
            System.out.println("XX向右移动");
        }
    },TOP("TOP");


    private final String desc;

    private Direction(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    //整个枚举类型只重写一次，所有对象调用一个
    @Override
    public void show() {
        System.out.println("Direction实现接口中抽象方法的重写");
    }
}
