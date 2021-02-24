package lagou.phase1.module3.work;

public class work01 {
    public static void main(String[] args) {
        String str = "ABCD123!@#$%ab";
        int upSum = 0;
        int lowSum = 0;
        int numSum = 0;
        int otherSum = 0;
        for (char c: str.toCharArray()) {
            if(String.valueOf(c).matches("[A-Z]")){
                upSum++;
            }else if(String.valueOf(c).matches("[a-z]")){
                lowSum++;
            }else if(String.valueOf(c).matches("[0-9]")){
                numSum++;
            }else{
                otherSum++;
            }

        }
        System.out.println("大写字母个数为:" + upSum);
        System.out.println("小写字母个数为:" + lowSum);
        System.out.println("数字个数为:" + numSum);
        System.out.println("其它字符个数为:" + otherSum);
    }
}
