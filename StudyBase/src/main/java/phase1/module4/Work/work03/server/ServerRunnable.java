package phase1.module4.Work.work03.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ServerRunnable  implements Runnable{

    private Socket s = null;

    public ServerRunnable(Socket s) {
        this.s = s;
    }

//    public void broadCast(String msg){
//        PrintStream ps = null;
//        try {
//
//            for(Map.Entry<String, Socket> m : Server.sockets.entrySet()) {
//                if(this.s == m.getValue()){
//                    continue;
//                }
//                ps = new PrintStream(m.getValue().getOutputStream());  //获取每一个socket的输出流
//                ps.println(m.getKey()+":"+msg);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public void run() {
        System.out.println("线程调用");
        BufferedReader br = null;
        PrintStream ps = null;
        Scanner sc = null;

        try {
            //3.使用输入输出流通信
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            sc = new Scanner(System.in);
            ps = new PrintStream(s.getOutputStream());
            while(true){
                //实现对客户端发来的字符串内容接收并打印
                String s1 = br.readLine();
                System.out.println("Client--"+s.getInetAddress()+s.getPort()+"发来的内容是:"+s1);
                if("bye".equalsIgnoreCase(s1)){
                    System.out.println("Client--"+s.getPort()+s.getInetAddress()+"已下线！");
                    break;
                }
                String username = "";
                for(Map.Entry<String, Socket> m : Server.sockets.entrySet()) {
                    if(this.s == m.getValue()){
                        username = m.getKey();
                        continue;
                    }

                }
                for(Map.Entry<String, Socket> m : Server.sockets.entrySet()) {
                    if(this.s == m.getValue()){
                        continue;
                    }
                    ps = new PrintStream(m.getValue().getOutputStream());  //获取每一个socket的输出流
                    ps.println(username+":"+s1);
                }
//                broadCast(s1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != sc){
                sc.close();
            }
            if (null != ps) {
                ps.close();
            }
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
