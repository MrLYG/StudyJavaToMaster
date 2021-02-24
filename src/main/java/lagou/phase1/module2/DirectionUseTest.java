package lagou.phase1.module2;


public class DirectionUseTest {
    public static void test1(Direction de){
        switch (de){
            case UP:
                System.out.println("上上"); break;
            default:
                System.out.println("没有");
        }
    }
    /**
     * java.lang.Enum
     * static T[] values() 返回当前类的对象
     * String toString() 返回当前枚举对象的名称
     * int ordinal()      返回枚举对象在枚举类中的索引位置
     * static T valueOf(String str) 将参数的字符串名转换为当前枚举类的对象
     * int compareTo(E o) 比较两个枚举对象在定义时的顺序
     */
    public static void main(String[] args) {
        DirectionUseTest.test1(Direction.UP);

        Direction[] arr = Direction.values();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("前枚举对象的名称" + arr[i].toString());
            System.out.println("对象在枚举类中的索引位置" + arr[i].ordinal());
        }
        System.out.println("-------------------------------------------------");
        Direction d1 = Direction.valueOf("UP");//java.lang.IllegalArgumentException 非法参数异常
        System.out.println("转换出来的对象名称是"+ d1.toString());
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("compare:"+ d1.compareTo(arr[i]));
        }
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            arr[i].show();
        }
    }
}
