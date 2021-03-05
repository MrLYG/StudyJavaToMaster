package server;

import model.UserMessage;

import java.io.IOException;

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
    public void serverReceive() throws IOException, ClassNotFoundException {
        UserMessage o = (UserMessage) sic.getOis().readObject();
        System.out.println("接收到的消息是"+o);
        if(sd.serverManagerCheck(o.getUser())){
            o.setType("success");
        }else {
            o.setType("fail");
        }
        //将校验结果发送给客户端
        sic.getOos().writeObject(o);
        System.out.println("服务器发送校验结果成功");
    }



}
