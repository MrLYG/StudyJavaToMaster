import java.util.*;

/**
 * @Author: Ken
 * @Date: 2021/7/15 18:22
 */
class Q5 {
    //先排序
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
//        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int lens = nums.length;
        for (int i = 0; i < lens; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            left = i + 1;
            right = lens - 1;
            while (left < right) {
//                System.out.println("i="+i);
//                System.out.println(left);
//                System.out.println(right);
                int sum = nums[i] + nums[left] + nums[right];
//                System.out.println(sum);
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List r = new ArrayList();
                    r.add(nums[i]);
                    r.add(nums[left]);
                    r.add(nums[right]);
                    res.add(r);
//                    set.add(r);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
//        Iterator<List<Integer>> iterator = set.iterator();
//        while(iterator.hasNext()){
//            res.add(iterator.next());
//        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Q5 q = new Q5();
        System.out.println(q.threeSum(nums));

    }
}
