package phase1.module3.work;

import java.util.HashMap;
import java.util.Map;

public class Work02 {
    /**
     * 准备一个 HashMap 集合，统计字符串"123,456,789,123,456"中每个数字字符串出现的次数并打印出来。
     *  如：
     *         123 出现了 2 次
     *         456 出现了 2 次
     *         789 出现了 1 次
     * @param args
     */
    public static void main(String[] args) {
        String str = "123,456,123,789,456,123,123";
        // 将str字符串，根据","分隔，存入字符串数组
        String[] strs = str.split(",");

        Map<String,Integer> m = new HashMap();


        // 把strs中的元素作为K输入到map中,判断元素是否存在，若存在该元素的V值+1
        for (String s: strs ) {
            if(m.containsKey(s)){   //判断map中是否已经包含该值，若包含该元素对应的value值+1;
                m.put(s,m.get(s)+1);
            }else {
                m.put(s,1);
            }
        }


        //遍历Map集合，打印目标文本
        for (Map.Entry<String,Integer> me: m.entrySet()) {
            System.out.println(me.getKey()+"出现了"+me.getValue()+"次");
        }
    }
}
