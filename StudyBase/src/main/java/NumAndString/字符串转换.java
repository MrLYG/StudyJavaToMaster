package NumAndString;

public class 字符串转换 {
    public static void main(String[] args) {
     //数字转String
        int i = 6;
        //method1
        String str = String.valueOf(i);
        str = str.concat("abc");
        //str = str + "abc";
        System.out.println(i);
        //method2 装箱 integer是个类继承Object类，有toString方法。
        Integer it = i;
        String str2 = it.toString();

     //String转数字
        int i2 = Integer.parseInt(str2) ;

        System.out.println(i);
        System.out.println(str);
        System.out.println(str2);
        System.out.println(i2);

        Double f = 3.14 ;
        String strF = String.valueOf(f);
        System.out.println(strF);

        double f2 = Double.parseDouble("3.1a4"); //如果String 不是合法表达会抛出转换异常（java.lang.NumberFormatException）
        System.out.println(f2);
    }
}
