package client;

import entity.Student;
import model.User;
import model.Message;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
                    System.out.println("正在进入学员系统.....");
                    clientStudentLogin();
                    break;
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
     * 学员登录
     */
    private void clientStudentLogin() throws IOException, ClassNotFoundException {
        System.out.println("请输入学员名称:");
        String userName = ClientScanner.getSc().next();
        System.out.println("请输入学员的密码信息(密码由性别和年龄组成)");
        String password = ClientScanner.getSc().next();
        Message um = new Message("stuCheck", new User(userName,password));

        //2.将userMessage类型的对象通过对象输出流发送给服务器
        cic.getOos().writeObject(um);
        System.out.println("客户端发送学员信息成功");

        //3.接受服务器的处理结果
        um = (Message) cic.getOis().readObject();
        if("success".equals(um.getType())){
            System.out.println("登录成功欢迎使用");
            studentMainPage();
        }else {
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 自定义方法实现绘制学员系统
     */
    private void studentMainPage() {




        return ;
    }



    /**
     * 自定义方法实现管理员登录
     */
    private void clientMangerLogin() throws IOException, ClassNotFoundException, InterruptedException {
        //.1.准备管理员登录的相关数据
        System.out.println("请输入管理员账户信息:");
        String userName = ClientScanner.getSc().next();
        System.out.println("请输入管理员的密码信息");
        String password = ClientScanner.getSc().next();
        Message um = new Message("managerCheck", new User(userName,password));
        //2.将userMessage类型的对象通过对象输出流发送给服务器
        cic.getOos().writeObject(um);
        System.out.println("客户端发送管理员信息成功");
        //3.接受服务器的处理结果
        um = (Message) cic.getOis().readObject();
        if("success".equals(um.getType())){
            System.out.println("登录成功欢迎使用");
            managerMainPage();
        }else {
            System.out.println("用户名或密码错误！");
        }

    }



    /***
     * 实现绘制管理员系统
     */
     public void managerMainPage() throws InterruptedException, IOException, ClassNotFoundException {
         while(true) {
             System.out.println("  \n\n\t\t   管理员系统");
             System.out.println("--------------------------------------");
             System.out.print("   [1] 学员管理系统");
             System.out.println("     [2] 考题管理系统");
             System.out.println("   [0] 退出系统");
             System.out.println("--------------------------------------");
             System.out.println("请选择要进行的业务编号;");
             int choose = ClientScanner.getSc().nextInt();
             switch (choose){
                 case 1:
                     System.out.println("学员管理系统.....");
                     stuManageView();
                     break;
                 case 2:
                     System.out.println("考题管理系统.....");
                     questionManageView();
                     break;
                 case 0:
                     System.out.println("正在退出.....");Thread.sleep(1000);
                     return;
                 default:
                     System.out.println("输入错误，请重新选择");
             }

         }
     }

    /**
     * 用于绘制考题管理模块界面
     */
    private void questionManageView() throws InterruptedException, IOException, ClassNotFoundException {
        QuestionOperateUtil questionOperateUtil = new QuestionOperateUtil();
        while(true) {
            System.out.println("  \n\n\t\t   考题管理");
            System.out.println("--------------------------------------");
            System.out.print("   [1] 导入考题");
            System.out.print("     [2] 删除考题");
            System.out.print("     [3] 修改考题");
            System.out.println("     [4] 查找考题");
            System.out.println("   [0] 退出系统");
            System.out.println("--------------------------------------");
            System.out.println("请选择要进行的业务编号;");
            int choose = ClientScanner.getSc().nextInt();
            switch (choose){
                case 1:
                    System.out.println("导入考题.....");
                    questionOperateUtil.addQuestion(cic);
                    break;
                case 2:
                    System.out.println("删除考题.....");
//                    questionOperateUtil.deleteQuestion(cic);
                    break;
                case 3:
                    System.out.println("修改考题.....");
                    questionOperateUtil.reviseQuestion(cic);

                    break;
                case 4:
                    System.out.println("查找考题.....");
                    questionOperateUtil.findQuestion(cic);
                    break;
                case 0:
                    questionOperateUtil.closeQuestion(cic);
                    System.out.println("正在退出.....");Thread.sleep(1000);
                    return;
                default:
                    System.out.println("输入错误，请重新选择");
            }

        }
    }


    /**
     * 自定义方法，进行学员管理界面编写
     */
    public void stuManageView() throws InterruptedException, IOException, ClassNotFoundException {
        StudentOperateUtil studentOperateUtil = new StudentOperateUtil();
        while(true) {
            System.out.println("  \n\n\t\t   学员管理");
            System.out.println("--------------------------------------");
            System.out.print("   [1] 增加学员");
            System.out.print("     [2] 删除学员");
            System.out.print("     [3] 修改学员");
            System.out.println("     [4] 查找学员");
            System.out.println("   [0] 退出系统");
            System.out.println("--------------------------------------");
            System.out.println("请选择要进行的业务编号;");
            int choose = ClientScanner.getSc().nextInt();
            switch (choose){
                case 1:
                    System.out.println("增加学员.....");
                    studentOperateUtil.addStu(cic);
                    break;
                case 2:
                    System.out.println("删除学员信息.....");
                    studentOperateUtil.deleteStu(cic);
                    break;
                case 3:
                    System.out.println("开始修改一个学生信息");
                    System.out.println("修改学员信息.....");
                    studentOperateUtil.reviseStu(cic);
                    break;
                case 4:
                    System.out.println("开始查询一个学生信息");
                    System.out.println("查找学员信息.....");
                    studentOperateUtil.findStus(cic);
                    break;
                case 0:
                    studentOperateUtil.closeStu(cic);
                    System.out.println("正在退出.....");Thread.sleep(1000);
                    return;
                default:
                    System.out.println("输入错误，请重新选择");
            }

        }
    }

}
