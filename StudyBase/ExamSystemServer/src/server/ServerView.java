package server;

import dao.ServerDao;
import entity.Student;
import model.User;
import model.Message;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/**
 * 编程实现服务器的主功能
 */
public class ServerView {
    private ServerInitClose sic;
    private ServerDao sd;

    public ServerView(ServerInitClose sic, ServerDao sd) {
        this.sic = sic;
        this.sd = sd;
    }

    /**
     * 实现客户端发来消息的接受并处理
     */
    public void serverReceive() throws IOException, ClassNotFoundException, InterruptedException {
        Message o = null;

        while (true) {
            try{
                o = (Message) sic.getOis().readObject();
            }catch (EOFException e){
                System.out.println("等待客户端输入命令");
                Thread.sleep(1000);
                continue;
            }
            System.out.println("接收到的消息是"+o);
            switch (o.getType()){
                case "managerCheck":
                    if(sd.serverManagerCheck((User) o.getT())){
                        o.setType("success");
                    }else {
                        o.setType("fail");
                    }
                    //将校验结果发送给客户端
                    sic.getOos().writeObject(o);
                    System.out.println("服务器发送校验结果成功!");
                    break;
                case "addStudent":
                    sd.addStudent((Student) o.getT()); //将接收到的学生信息传入DAO中的addStudent方法;
                    break;
                case "findStus":
                    List res = sd.findStus((Student) o.getT());
                    Message m = new Message("success",res);    //构建Message对象，传输给服务端，告诉服务端该功能是否完成，并传输数据
                    sic.getOos().writeObject(m);
                    break;
                case "deleteStu":
                    sd.deleteStu((Student) o.getT());
                    //构建Message对象，传输给服务端，告诉服务端该功能是否完成，并传输数据
                    Message mDeleteStu = new Message("success","");
                    sic.getOos().writeObject(mDeleteStu);
                    break;
                case "reviseStudent":
                    sd.reviseStudent((Student) o.getT());
                    break;
                case "closeStu":
                    sd.closeStu();
                    break;

            }
        }


    }

    /**
     * 实现服务端增加成员
     */
    public void addStudent(){

    }



}

