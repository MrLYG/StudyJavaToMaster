package DataStructureAndAlgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr,int left, int right){
        if(left>=right){
            return;
        }
        int index = arr[left];
        int i = left;
        int j = right;
        while(i!=j){
            while ( i<j && arr[j]>=index ){ //此处的等号 有等号就是 基准值右边的数大于等于基准值， 无等号左边的值小于等于基准值
                j--;
            }
            while( i<j && arr[i]<=index ){
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];

            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = index;
        System.out.println(Arrays.toString(arr));
        quickSort(arr,left,i-1);
        quickSort(arr,j+1,right);
    }
    public static void main(String[] args) {
        int[] arr = new int[] {9,4,11,8,3,9,10,12,11,5};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
