package NumAndString;

import java.util.Scanner;

public class 字符 {
    public static void main(String[] args) {
        System.out.println("\\\\");
        Character ch = 'a';
        String s = Character.toString(ch);
        String s1 = String.valueOf(ch);
        System.out.println(s);
        System.out.println(s1);

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cs = str.toCharArray();
        for(int i = 0; i < cs.length; i++){
            if(Character.isUpperCase(cs[i]) || Character.isDigit(cs[i])){
                System.out.print(cs[i]);
            }
        }

    }
}
