import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetToK {
    /**
     * 给定一个整数数组 nums 和一个目标值 k，请实现一个方法判断 nums 中是否存在某个片段（即若干个相连元素）之和等于 k。要求时间复杂度为 O(n)。
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSum(int[] nums, int k) {
        // Write your code here.
        int sum = 0;   //用sum作为中间者，将数组nums的前N项和存入HashMap中
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();  //利用Hash的特性减少重复判断

        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                sum = nums[i];
                map.put(i,sum);
                continue;
            }
            sum = sum + nums[i];
            map.put(i,sum);    //此用例 map最后生成的内容为:{0=1, 1=3, 2=6, 3=10, 4=15, 5=21, 6=28, 7=36, 8=45, 9=55}
        }

        for (int i = 0; i < nums.length; i++) {
            //某一片段的和为 片段末尾位置的前n项和减去片段头位置的前n项和
            //==> k = right - left ==> right = left + k  所以从0位置开始遍历map ，
            // 每次取出的都是片段left的值，然后加上K，看看在map中是否存在这个right的值
            if(map.containsValue(map.get(i)+k)){
                return true;
            }
        }
        System.out.println(map);
        return false;
    }

    public static void main(String[] args) {
        TargetToK targetToK = new TargetToK();
        int[] testCase = {1,2,3,4,5,6,7,8,9,10};
        int k = 5;
        Boolean flag = targetToK.checkSum(testCase,k);
        if(flag){
            System.out.println("存在某个片段（即若干个相连元素）之和等于: " + k );
        }else {
            System.out.println("不存在某个片段（即若干个相连元素）之和等于 k");
        }
    }

}
