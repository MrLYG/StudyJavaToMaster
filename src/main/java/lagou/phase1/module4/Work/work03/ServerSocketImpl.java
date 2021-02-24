package lagou.phase1.module4.Work.work03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ServerSocketImpl {
    public static void main(String[] args) throws IOException {
        //用于存放发送数据过来的客户端的ip和端口
        Set<Socket> ipAndPort = new HashSet<>();

        ServerSocket ss = null;
        Socket s = null;
        BufferedReader bf = null;
        PrintStream ps =null;

        ss = new ServerSocket(6666);
        while (true) {
            s = ss.accept();
            ipAndPort.add(s);
//            bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            String cToS = bf.readLine(); //接收Client发送过来的数据
//            ps = new PrintStream(s.getOutputStream());
//            ps.println(cToS);
            System.out.println(ipAndPort);
        }






    }
}
