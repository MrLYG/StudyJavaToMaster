package phase1.base;

public class Work03 {
    /**
     * 3. 编程题 使用双重循环实现五子棋游戏棋盘的绘制，棋盘界面的具体效果如下：
     * @param args
     */
    public static void main(String[] args) {
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){

                if(i == 0 && j == 0){       //画左上角的缺角
                    System.out.print("   ");
                    continue;
                }

                if(i == 0){    //判断是否为第一行
                    if(j>=10){  //如果第一行列数大于等于10，将数字转换为字母
                        System.out.print(" "+(char)(j-10+'a')+" ");
                        continue;
                    }
                    System.out.print(" "+j+" ");
                    continue;
                }

                if(j == 0){    //判断是否为第一列
                    if(i>=10){  //如果第一列行数大于等于10，将数字转换为字母
                        System.out.print(" "+(char)(i-10+'a')+" ");
                        continue;
                    }
                    System.out.print(" "+i+" ");
                    continue;
                }

                System.out.print(" + ");
            }
            System.out.println();
        }
    }
}
