package phase1.module4.Work.work03.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable{
    public Socket clientSocket = null;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        BufferedReader brx = null;
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
}
