import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Socket socket =null;
        try {
            //1.实例化监听套接字
            ServerSocket server = new ServerSocket(1994);
            /**
             * 根据监听套接字获取套接字，当每有一个客户端连接服务器时，开启一个子线程进行通讯,
             * 将通讯交给子线程完成
             */
            while(true){
                socket = server.accept();

                new Thread(new Service(socket)).start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}