package lagou.phase1.module2;

import java.util.Scanner;

public class  GoBang {
    public int[][] board = new int[16][16];
    public int count = 0;  //用来记数，和判断黑白方

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 根据下棋双方落子情况，重新画棋盘
     * @param i
     * @param j
     */
    public void drawBorad(int i, int j){
        //判断重复
        if(board[i][j]!=0){
            System.out.println("请不要在已经下过的地方落子！！！");
            count -- ;    //回退到上一个状态
            return;
        }
        if(count%2 == 1){
            System.out.println("白子落子完毕");
            System.out.println("请黑子方输入落子的坐标");
            board[i][j] = 1; //1代表白子
        }else{
            System.out.println("黑子落子完毕");
            System.out.println("请白子方输入落子的坐标");
            board[i][j] = 2; //2代表黑子
        }

    }

    /**
     * 根据下棋情况实时打印棋盘
     */
    public void printBorad(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){

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
                if(board[i][j]!=0){
                    System.out.print(" "+board[i][j]+" ");
                    continue;
                }
                System.out.print(" + ");
            }
            System.out.println();
        }
    }

    /**
     * 判断是否有棋子胜利
     * @return
     */
    public Boolean isWin(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 1){
                    int index = 1; //往各个方向移步
                    while(board[i+index][j] == 1 && i+index<board.length){
                        index++;
                        if(index == 5){
                            System.out.println("白子获胜");
                            return true;
                        }
                    }
                    index = 1; //往各个方向移步
                    while(board[i][j+index] == 1 && j+index<board.length){
                        index++;
                        if(index == 5){
                            System.out.println("白子获胜");
                            return true;
                        }
                    }
                    index = 1; //往各个方向移步
                    while(board[i+index][j+index] == 1 && i+index<board.length && j+index<board.length){
                        index++;
                        if(index == 5){
                            System.out.println("白子获胜");
                            return true;
                        }
                    }

                }
                if(board[i][j] == 2){
                    int index = 1; //往各个方向移步
                    while(board[i+index][j] == 2 && i+index<board.length){
                        index++;
                        if(index == 5){
                            System.out.println("黑子获胜");
                            return true;
                        }
                    }
                    index = 1; //往各个方向移步
                    while(board[i][j+index] == 2 && j+index<board.length){
                        index++;
                        if(index == 5){
                            System.out.println("黑子获胜");
                            return true;
                        }
                    }
                    index = 1; //往各个方向移步
                    while(board[i+index][j+index] == 2 && i+index<board.length && j+index<board.length){
                        index++;
                        if(index == 5){
                            System.out.println("黑子获胜");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断落子是否合法
     * @param x
     * @return
     */
    public boolean isVaildPos(int x){
        if(x < 1 || x > 15){
            System.out.println("棋子所落范围大于棋盘宽度，请从新输入棋子和横纵坐标");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GoBang goBang = new GoBang();
        Scanner sc = new Scanner(System.in);
        int row = 0;
        int col = 0;
        Boolean flag = false;
        System.out.println("请白子方输入落子的坐标");
        while(!flag){
            row = sc.nextInt();
            if(goBang.isVaildPos(row)){
                continue;
            }
            col = sc.nextInt();
            if(goBang.isVaildPos(col)){
                continue;
            }
            goBang.setCount(goBang.getCount()+1);    //设置回合数
            goBang.drawBorad(row,col);    //将将下棋的坐标输入棋盘，绘画棋盘，根据回合数判断是白子还是黑子
            goBang.printBorad();          //打印棋盘
            flag = goBang.isWin();        //判断是否胜利
        }


    }
}
