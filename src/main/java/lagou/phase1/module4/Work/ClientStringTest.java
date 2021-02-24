package lagou.phase1.module4.Work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientStringTest {
    public static void main(String[] args) {
        Socket s = null ;
        PrintStream ps = null;
        Scanner sc = null;
        BufferedReader br = null;
        try {
            s = new Socket("127.0.0.1",6666);
            System.out.println("连接服务器成功！");

            //2.使用输入输出流进行通信
            sc = new Scanner(System.in);
            ps = new PrintStream(s.getOutputStream());  //输出，向server输入

            br = new BufferedReader(new InputStreamReader(s.getInputStream())); //输入，接收server发来的数据
            while (true) {
                //向服务端发送数据
                System.out.println("请输入要发送的数据内容:");
                String s1 = sc.next();

                ps.println(s1);

                System.out.println("Client发送数据内容成功!");
                if("bye".equalsIgnoreCase(s1)){
                    break;
                }

                //接收服务端发来的数据
                String serverSToClient = br.readLine(); //
                System.out.println("Server--发来的内容是:"+serverSToClient);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != ps){
                ps.close();
            }

            if(null != s){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
