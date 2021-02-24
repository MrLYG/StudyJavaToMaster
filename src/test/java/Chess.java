import java.util.Arrays;
import java.util.Scanner;

public class Chess {
    public static String chessVictor(int[][] arr,int n){

        for(int i = 0;i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    continue;
                }
                //1.胜利情况
                if(arr[i][j] == arr[i][j+1]){
                    Boolean flag = true;
                    if(n-j>5){
                        for(int x = 1; x <= 4; x++ ){
                            if(arr[i][j+x] != arr[i][j+x+1] ){
                                flag = false;
                                break;
                            }

                        }
                    }
                    if(flag){
                        if(arr[i][j] == 1){
                            return "黑子";
                        }else if(arr[i][j] == -1){
                            return "白子";
                        }
                    }
                }
                //2.
                if(arr[i][j] == arr[i+1][j]) {
                    Boolean flag = true;
                    if (n - i > 5) {
                        for (int x = 1; x <= 4; x++) {
                            if (arr[i + x][j] != arr[i + x + 1][j]) {
                                flag = false;
                                break;
                            }

                        }
                    }
                    if (flag) {
                        if (arr[i][j] == 1) {
                            return "黑子";
                        } else if (arr[i][j] == -1) {
                            return "白子";
                        }
                    }
                }
                //3.
                if(arr[i][j] == arr[i+1][j+1]) {
                    Boolean flag = true;
                    if (n - i > 5 && n-j > 5) {
                        for (int x = 1; x <= 4; x++) {
                            if (arr[i + x][j+x] != arr[i + x + 1][j+x+1]) {
                                flag = false;
                                break;
                            }

                        }
                    }
                    if (flag) {
                        if (arr[i][j] == 1) {
                            return "黑子";
                        } else if (arr[i][j] == -1) {
                            return "白子";
                        }
                    }
                }
                //4.
                if(j == 0)
                    continue;

                if(arr[i][j] == arr[i+1][j-1]) {
                    Boolean flag = true;
                    if (j < n && n - j > 2 && n-j > 5) {
                        for (int x = 1; x <= 4; x++) {
                            if (arr[i + x][j-x] != arr[i + x + 1][j-x-1]) {
                                flag = false;
                                break;
                            }

                        }
                    }
                    if (flag) {
                        if (arr[i][j] == 1) {
                            return "黑子";
                        } else if (arr[i][j] == -1) {
                            return "白子";
                        }
                    }
                }
                System.out.println(arr[i][j]);
            }
        }
        return "无人获胜";

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入n*n的棋盘大小:");
        int n = sc.nextInt();
//        int[][] arr = {{-1,-1,-1,-1,-1,-1},
//                {1,-0,1,0,1,-1},
//                {-1,-1,-1,1,1,-1},
//                {1,-1,0,-1,-1,1},
//                {1,1,-1,1,1,1},
//                {-1,1,-1,1,-1,1}
//        };
        int[][] arr;
        arr = new int[n][n];
        System.out.println("请输入数组内容");
        for(int i = 0;i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();;
            }
        }
       // System.out.println(Arrays.toString(arr));
        System.out.println(chessVictor(arr,n));
    }
}
