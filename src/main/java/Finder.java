import java.util.*;

public class Finder {

    public static void QuickFind(int[] arr, int left, int right, int k){
        if(left>=right)
            return ;
        int index = arr[left];
        int i = left;
        int j = right;
        while(i!=j){
            while(i<j&&arr[j]>=index){
                j--;
            }
            while(i<j&&arr[i]<=index){
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = index;
        System.out.println(Arrays.toString(arr));
        if(i==k){
            System.out.println(arr[i]);
        }
        QuickFind(arr,left,i-1,k);
        QuickFind(arr,i+1,right,k);

    }
//    public static int findKth(int[] a, int n, int K) {
//        // write code here
//
//        QuickFind(a,0,n-1,K );
//        return kn;
//    }

    public static void main(String[] args) {
        int[] a = new int[5];
        a[0]=1;
        a[1]=3;
        a[2]=5;
        a[3]=2;
        a[4]=2;
        QuickFind(a,0,a.length-1,1);

    }
}