package lagou.phase1.module4.Work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{
    private Socket s = null;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
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
                //实现向客户端回发内容并打印
//                System.out.println("Server--请输入要发送的数据内容:");
//                String sToClient = sc.next();
//                ps.println(sToClient);
                ps.println("I received");
//                System.out.println("Server--发送数据内容成功!");
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
