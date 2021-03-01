package phase1.module4.Work.work03.server;

import phase1.module4.Work.ServerThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static Map<String,Socket> sockets = new HashMap<>();
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        BufferedReader br = null;
        try {
            ss  = new ServerSocket(6666);
            while (true) {
                System.out.println("等待客户端的请求连接...");
                s = ss.accept();


                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String name = br.readLine();
                if( name.contains("^&*)8947!@!")){
                    sockets.put(name.substring("^&*)8947!@!".length()),s);
                }
                System.out.println(name + "连接成功!");
                new Thread(new ServerRunnable(s)).start();
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
