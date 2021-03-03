package phase1.module4.Work.work03.client;

import phase1.module3.teach.fanXing.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void connect(){
        System.out.println("请先输入姓名，然后进入聊天室");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();


        PrintStream ps = null; //输出流 向服务器方式消息
        BufferedReader br = null;
        Socket clientSocket = null;

        try {
            clientSocket = new Socket("127.0.0.1",6666);
            System.out.println("进入聊天室成功！");

            ps = new PrintStream(clientSocket.getOutputStream());  //输出，向server输入
            ps.println("^&*)8947!@!"+userName); //先将姓名发送到服务器，记录姓名

            //开启一个线程接收server发来的数据
            new Thread(new ClientThread(clientSocket)).start();

            while (true) {
                String s1 = sc.next();
                ps.println(s1);
                if("bye".equalsIgnoreCase(s1)){
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=clientSocket){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
