package client;

import model.User;
import model.UserMessage;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.IOException;
import java.util.Scanner;

/**
 * 实现客户端界面的实现和相应功能的实现
 */
public class ClientView {

    private ClientInitClose cic ;

    public ClientView(ClientInitClose cic){
        this.cic = cic;
    }


    /**
     * 实现客户端主界面的绘制
     */
    public void clientMainPage() throws InterruptedException, IOException, ClassNotFoundException {
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
    private void clientMangerLogin() throws IOException, ClassNotFoundException {
        //.1.准备管理员登录的相关数据
        System.out.println("请输入管理员账户信息:");
        String userName = ClientScanner.getSc().next();
        System.out.println("请输入管理员的密码信息");
        String password = ClientScanner.getSc().next();
        UserMessage um = new UserMessage("managerCheck", new User(userName,password));
        //2.将userMessage类型的对象通过对象输出流发送给服务器
        cic.getOos().writeObject(um);
        System.out.println("客户端发送管理员信息成功");
        //3.接受服务器的处理结果
        um = (UserMessage) cic.getOis().readObject();
        if("success".equals(um.getType())){
            System.out.println("登录成功欢迎使用");
        }else {
            System.out.println("用户名或密码错误！");
        }

    }
}
