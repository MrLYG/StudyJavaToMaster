package NumAndString;

public class 装箱拆箱 {
    public static void main(String[] args){
        int i = 10;
        //手动装箱
        Integer it = new Integer(i);
        //手动拆箱
        int it2 = it.intValue();
        System.out.println(it);
        System.out.println(it2);

        //Number 抽象类 其子类包括 Byte、float、double、short、long、integer
        System.out.println( it instanceof Number);

        //自动装箱
        Integer autoInt = 6;
        System.out.println("autoInt="+autoInt);

        //自动拆箱
        int autoChai = autoInt;
        System.out.println("autoChai="+autoChai);

        //int的最大值
        System.out.println(Integer.MAX_VALUE);
        //int的最小值
        System.out.println(Integer.MIN_VALUE);

        //Byte
        Byte b = 2;
        byte c = b;
        System.out.println(b);
        System.out.println(c);

        //byte和Integer 之间不能自动装箱和拆箱
        //Integer cInt = c;
        //b = new Integer(2);
        //b = autoInt;
    }
}
