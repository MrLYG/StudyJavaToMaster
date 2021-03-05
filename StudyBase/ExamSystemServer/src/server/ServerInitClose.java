package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 变成实现服务器的初始化和关闭
 */
public class ServerInitClose {
    private ServerSocket ss = null;
    private Socket s = null;
    private ObjectInputStream ois = null;

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    private ObjectOutputStream oos = null;
    /**
     * 自定义成员方法实现服务器的初始化操作
     */
    public void serverInit() throws IOException {
        //1.创建serverSocket对象
        ss = new ServerSocket(6666);
        //2.accept（）
        System.out.println("wait client to connect...");
        s = ss.accept();
        System.out.println("client connect success!");
        //3.输入输出流通信
        ois = new ObjectInputStream(s.getInputStream());
        oos = new ObjectOutputStream(s.getOutputStream());
        System.out.println("server init success!");

    }

    /**
     * 成员方法，实现服务器的关闭操作
     */
    public void serverClose() throws IOException {
        //4.关闭socket，并释放相关资源
        oos.close();
        ois.close();;
        s.close();
        ss.close();
    }
}
