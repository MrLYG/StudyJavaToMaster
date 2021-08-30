import java.util.Arrays;

/**
 * @Author: Ken
 * @Date: 2021/8/9 13:15
 */
class Q34 {
    public static void main(String[] args) {
        Q34 q = new Q34();
        int[] nums = new int[]{1};
        int[] r = q.searchRange(nums,1);
        System.out.println(Arrays.toString(r));
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = findFirstPositionOfTarget(nums, target);
        res[1] = findLastPositionOfTarget(nums, target);
        return res;
    }

    private int findFirstPositionOfTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid -1;
            }
        }

        return -1;
    }

    private int findLastPositionOfTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (target > nums[mid]) {
                left = mid;
            } else if (target < nums[mid]) {
                right = mid;
            }
        }
        if( nums[right] == target ) {
            return right;
        }
        if( nums[left] == target ) {
            return left;
        }
        return -1;
    }
}
