package lagou.phase1.module4.Work;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStringTest {
    public static void main(String[] args){
        ServerSocket ss = null;
        Socket s = null;
        try {
            ss  = new ServerSocket(6666);
            while (true) {
                System.out.println("等待客户端的请求连接...");
                s = ss.accept();
                System.out.println("客户端连接成功!");
                new ServerThread(s).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != s){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != ss){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
