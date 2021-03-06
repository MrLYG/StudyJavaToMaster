package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 实现客户端的初始化和关闭操作
 */
public class ClientInitClose {
    private Socket s = null;
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public void clientInit() throws IOException {
        //1.创建socket
        s = new Socket(InetAddress.getLocalHost(),6666);
        System.out.println("connect Server success!");
        //2.使用输入输出流通信
        oos = new ObjectOutputStream(s.getOutputStream());
        ois = new ObjectInputStream(s.getInputStream());

    }

    public void clientClose() throws IOException {
        //3.关闭流对象
        ois.close();
        oos.close();
        s.close();
    }

}
