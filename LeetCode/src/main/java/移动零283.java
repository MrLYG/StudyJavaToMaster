/**
 * @Author: Ken
 * @Date: 2021/6/26 16:18
 */
class Q283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
            }
        }
    }
}
