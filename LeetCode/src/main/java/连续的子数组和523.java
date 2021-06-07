import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ken
 * @Date: 2021/6/2 10:36
 */
class Q523 {

    public static boolean checkSubarraySum(int[] nums, int k) {

        Map map = new HashMap<>();
        int sum = 0;
        int rem = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rem = sum % k;
            if (!map.containsKey(rem)) {
                map.put(rem, i);
            } else {
                Integer o = (Integer) map.get(rem);
                if (i - o >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{23, 2, 4, 6, 6};
        checkSubarraySum(nums, 7);
    }
}
