package NumAndString;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 字符串 {

    //返回长度是5的随机字符
    public static String randomString(int num){
        char[] cs = new char[num];
        short start = '0';
        short end = 'z'+1;
        for(int i = 0; i < cs.length; i++){
            while (true){
                char c = (char)((Math.random() * (end - start)) +start);
                if(Character.isDigit(c) || Character.isLetter(c)){
                    cs[i] = c;
                    break;
                }
            }

        }
        String str = new String(cs);
        return str;
    }

    public static void main(String[] args) {
        String xx = null ; //无指向！！！xx.length() 会报出空指针异常 java.lang.NullPointerException
        //System.out.print(xx.length());

        //创建长度为5的随机字符串
        String[] strs = new String[8];
        for(int i = 0; i < strs.length; i++){
            strs[i] = randomString(5);
        }
        System.out.println(Arrays.toString(strs));

        //冒泡排序
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs.length-i-1; j++){
                char prev = Character.toLowerCase(strs[j].charAt(0));                       ;
                char next = Character.toLowerCase(strs[j+1].charAt(0));
                if (prev > next){
                    String temp = "";
                    temp = strs[j];
                    strs[j] = strs[j+1];
                    strs[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(strs));






    }

}
