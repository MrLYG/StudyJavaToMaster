public class M {
    public static String judgeIpv4(String ip) {
        String[] strIp = ip.split("\\.",-1);
        for(int i = 0; i < strIp.length; i++){
            //ip地址必须都为数字
            char[] digitIp = strIp[i].toCharArray();
            for(int j = 0; j < strIp[i].length() ;j++){
                if(digitIp[j]<48 || digitIp[j]>57){
                    return "flaseIP";
                }
            }
            //IP地址开头不能为0.例如 192.0.01.0
            if(strIp[i].charAt(0) == '0' && strIp[i].length() != 1 ){
                return "flaseIP";
            }
            //IP地址长度每个点之间至少有1个数字并且少于等于3个数字
            if(strIp[i].length() == 0 || strIp[i].length() > 3 ){
                return "flaseIP";
            }
            //ip地址的值小于255
            if(Integer.parseInt(strIp[i])>255){
                return "flaseIP";
            }

        }
        return "trueIp";
    }
    public static void main(String[] args) {
        //测试用例
        //1.IP地址开头不能为0.例如 192.0.01.0
        String res = judgeIpv4("192.0.01.0");
        //2.IP地址长度每个点之间至少有1个数字并且少于等于3个数字
        //3.ip地址的值小于255
        String res2 = judgeIpv4("1923.0.0.0");
        //4.ip地址必须都为数字
        String res3 = judgeIpv4("192.0.0.f");
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
        //正常IP测试
        System.out.println(judgeIpv4("192.0.0.8"));
    }
}
