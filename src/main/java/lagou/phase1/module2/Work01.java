package lagou.phase1.module2;

import java.util.Arrays;

public class Work01 {
    /**
     * 1. 编程实现以下需求：
     * 定义一个长度为[16][16]的整型二维数组并随机生成所有位置的元素值(1~100)，分别实现二维数组每行元素的累加和及每列元素的累加和并打印。
     * 再分别实现二维数组中左上角到右下角和右上角到左下角所有元素的累加和并打印。
     */

    /**
     * 打印数组方法
     * @param arr
     */
    public static void printArr(int[][] arr){
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%-4d ",arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 对角线相加方法
     * @param arr
     */
    public static void diagonalAdd(int[][] arr){
        int leftToRight = 0;
        int rightToLeft = 0;
        for(int i = 1; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length-1; j++) {
                if(i == j){
                    leftToRight += arr[i][j];
                }
                if(i == arr.length-1 - j){
                    rightToLeft += arr[i][j];
                }
            }
        }
        arr[0][arr.length-1] = leftToRight;
        arr[arr.length-1][arr.length-1] = rightToLeft;
    }

    /**
     * 行列累加方法
     * @param arr
     */
    public static void rowAndColumnAdd(int[][] arr){
        for(int i = 1; i < arr.length-1; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 1; j < arr.length-1; j++) {
                rowSum += arr[i][j];
                columnSum += arr[j][i];
            }
            arr[i][arr.length-1] = rowSum;
            arr[arr.length-1][i] = columnSum;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[18][18];  /**
         *  多余的两行两列用途为，
         *  最后一列存放每一行的累加和，
         *  最后一行存放每一列的累加和，
         *  右上角存放从左下角到右上角的和，
         *  右下角存放左上角到右下角的和。
         */

        for(int i = 1; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length-1 ; j++) {
                arr[i][j] = (int) (Math.random()*100+1);;
            }
        }

        rowAndColumnAdd(arr); //调用行列累加方法
        diagonalAdd(arr);     //调用对角线累加方法
        printArr(arr);        //调用数组输出方法
    }
}
