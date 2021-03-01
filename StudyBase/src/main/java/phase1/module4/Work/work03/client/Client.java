package phase1.module4.Work.work03.client;

import phase1.module3.teach.fanXing.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket clientSocket = null;
    public static void main(String[] args) {
        System.out.println("请先输入姓名，然后进入聊天室");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();


        PrintStream ps = null; //输出流 向服务器方式消息
        BufferedReader br = null;


        try {
            clientSocket = new Socket("127.0.0.1",6666);
            System.out.println("进入聊天室成功！");

            ps = new PrintStream(clientSocket.getOutputStream());  //输出，向server输入
            ps.println("^&*)8947!@!"+userName); //先将姓名发送到服务器，记录姓名

             //输入，接收server发来的数据

            Runnable r = new Runnable() {
                BufferedReader brx = null;
                @Override
                public void run() {

                    try {
                        brx = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        String str = null;
                        while (true) {
                            if(null != (str= brx.readLine())){
                                System.out.println(str);
                            }
                        }
                        //接收服务端发来的数据

                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            brx.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            };
            new Thread(r).start();

            while (true) {
                //接收服务端发来的数据
//                String str = null;
//                if(null != (str= br.readLine())) System.out.println(str);
//                String serverSToClient = br.readLine(); //


                //向服务端发送数据
//                System.out.print(userName+":");
                String s1 = sc.next();
                ps.println(s1);
//                System.out.println("Client发送数据内容成功!");
                if("bye".equalsIgnoreCase(s1)){
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
