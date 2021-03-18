package Test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XC {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/

    static  int countAscii(String str){
        char[] cs=str.toCharArray();
        int sum = 0;
        for(int i :cs){
            sum +=i;
        }
        return  sum;

    }

    static int calcSimilarity(String name1, String name2) {

        int sumAscii = 0;
        List<String> name1s = new ArrayList(Arrays.asList(name1.split(" ")));
        List<String> name2s = new ArrayList(Arrays.asList(name2.split(" ")));
        int len = name1s.size()-name2s.size();
        int l = 0;
        if(len>0){
            for (int i = name1s.size()-1 ; len>0 ; i--,len--) {
                String str = name1s.get(i);
                sumAscii += countAscii(str);
                name1s.remove(i);
            }
            l = name1s.size();
        }else if(len < 0){
            len *=-1;
            for (int i = name2s.size()-1 ; len>0 ; i--,len--) {
                String str = name2s.get(i);
                sumAscii += countAscii(str);
                name2s.remove(i);
            }
            l = name2s.size();
        }

        l = name2s.size();

        for (int i = 0; i < l ; i++) {

            char[] chars1 = name1s.get(i).toCharArray();
            char[] chars2 = name2s.get(i).toCharArray();

            List<String> cs1 = new ArrayList<>();
            List<String> cs2 = new ArrayList<>();

            for (char c: chars1  ) {
                cs1.add( String.valueOf(c));
            }

            for (char c: chars2  ) {
                cs2.add( String.valueOf(c));
            }



            int ll = chars1.length - chars2.length;

            if(ll>0){
                for (int j = cs1.size()-1 ; ll>0 ; j--,ll--) {
                    String str = String.valueOf(chars1[j]);
                    sumAscii += countAscii(str);
                    cs1.remove(j);
                }
            }else if(ll < 0){
                ll *=-1;
                for (int j = cs2.size()-1; ll>0 ; j--,ll--) {
                    String str = String.valueOf(chars2[j]);
                    sumAscii += countAscii(str);
                    cs2.remove(j);
                }
            }



            for(int j = 0; j<cs1.size();j++){
                String t1 = cs1.get(j);
                String t2 = cs2.get(j);

                if(!t1.equals(t2)){
                    sumAscii += countAscii(t1);
                    sumAscii += countAscii(t2);
                }
            }




        }

        return sumAscii;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
////            String name1 = in.nextLine();
////            String name2 = in.nextLine();
//
//        }
        String name1 = "Zhang";
        String name2 = "Zhanag";
        int sum = calcSimilarity(name1, name2);
        System.out.println(sum);
    }
}
