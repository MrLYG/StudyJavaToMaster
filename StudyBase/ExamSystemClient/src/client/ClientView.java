package client;

import java.util.Scanner;

/**
 * 实现客户端界面的实现和相应功能的实现
 */
public class ClientView {
    /**
     * 实现客户端主界面的绘制
     */
    public void clientMainPage() throws InterruptedException {
        while(true) {
            System.out.println("  \n\n\t\t   在线考试系统");
            System.out.println("--------------------------------------");
            System.out.print("   [1] 学员系统");
            System.out.println("     [2] 管理员系统");
            System.out.println("   [0] 退出系统");
            System.out.println("--------------------------------------");
            System.out.println("请选择要进行的业务编号;");
            int choose = ClientScanner.getSc().nextInt();
            switch (choose){
                case 1:
                    System.out.println("正在进入学员系统....."); break;
                case 2:
                    System.out.println("正在进入管理员系统.....");
                    clientMangerLogin();
                    break;
                case 0:
                    System.out.println("正在退出系统.....");Thread.sleep(1000);
                    return;
                default:
                    System.out.println("输入错误，请重新选择");
            }

        }
    }

    /**
     * 自定义方法实现管理员登录
     */
    private void clientMangerLogin() {

    }
}
