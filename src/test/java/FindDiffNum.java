import java.util.*;

public class FindDiffNum {
    public static void main(String[] args) {
        final List A = new ArrayList();
        final List B = new ArrayList();
        for (int i = 0; i<=10;i++){
            A.add(i);
        }
        for (int j=6;j<=15;j++){
            B.add(j);
        }
        System.out.println(A);
        System.out.println(B);
        System.out.print("不重复元素为:");
        final Set C= new HashSet();

        for (int i = 0; i<=A.size()-1;i++){
            if(!B.contains(A.get(i))){
               C.add(A.get(i));
            }
        }
        for (int i = 0; i<=B.size()-1;i++){
            if(!A.contains(B.get(i))){
                C.add(B.get(i));
            }
        }
        System.out.print(C);
    }
}
