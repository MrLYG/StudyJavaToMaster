/**
 * @Author: Ken
 * @Date: 2021/6/26 13:51
 */
class Q11 {
    /**
     * 时间超出
     */
//    public int maxArea(int[] height) {
//        if(height.length<=1) {
//            return 0;
//        }
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                int h = height[i] > height[j] ? height[j]:height[i];
//                max = (j-i)*h > max ? (j-i)*h:max;
//            }
//        }
//
//        return max;
//    }
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        while (i < j) {
            int d = j - i;
            int h = height[i] > height[j] ? height[j--] : height[i++];
            max = d* h > max ? d* h : max;
        }
        return max;
    }

}
