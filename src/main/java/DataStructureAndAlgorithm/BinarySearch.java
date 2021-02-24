package DataStructureAndAlgorithm;

public class BinarySearch {

    public static int search(int[] nums,int left,int right,int target){
        int index = (right-left)/2 +left;
        if(left>right||index>nums.length-1) {
            return -1;
        }
        if(nums[index]== target) return index;
        if(target < nums[index]){
            return search(nums,left,index-1,target);
        }
        if(target > nums[index]){
            return search(nums,index+1,right,target);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums,0,nums.length,13));
    }
}
