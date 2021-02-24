package lagou.phase1.base;

import java.util.Arrays;
import java.util.Scanner;

public class Work02 {
/**
 * 2. 编程题 实现数组扩容。自定义数组长度（用户指定），扩容规则：当已存储元素数量达到总容量的 80%时，扩容到原容量的1.5 倍。
 * 例如，原容量是 10，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15。
 */
    public static int[] expandArray(int[] arr){  //数组扩容方法
        int[] arrNew = new int[arr.length*15/10]; //创建新的数组并将数组长度定义为扩容长度
        // 循环将arr数组的内容拷贝到arrNew数组中
        int i = 0;
        while ( i< arr.length ){
            arrNew[i] = arr[i++];
        }
        System.out.println("数组扩容到 "+arr.length*15/10+" 长度");
        return arrNew;
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        int index=0;
        while(true){
            arr[index++] = sc.nextInt();  //循环给arr数组赋值
            if(index>=arr.length*0.8){    //判断已存储元素数量是否达到总容量的80%
                arr = expandArray(arr);   //如达到总容量的80%时，则调用expandArray()方法,对arr数组扩容
            }
            System.out.println(Arrays.toString(arr));
        }


    }


}
