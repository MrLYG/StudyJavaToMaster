import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {

    /**
     * @param args
     */
    private static BufferedWriter writer;
    private static BufferedReader reader_keyboard,readr_fromServer;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Socket socket = null;
        try {
            //1.实例化套接字，并指定主机地址和端口号
            socket = new Socket(InetAddress.getLocalHost(), 1994);
            //向服务器写入数据的流
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //接收从键盘输入的数据
            reader_keyboard = new BufferedReader(new InputStreamReader(System.in));
            readr_fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String content = null;
            String contentFromServer = null;
            do{
                System.out.println("请输入信息：");
                content = reader_keyboard.readLine();
                if(content.equals("over")){
                    break;
                }
                writer.write(content);
                writer.newLine();
                writer.flush();
                contentFromServer = readr_fromServer.readLine();
//                if(contentFromServer!=null){
//                    System.out.println("服务器："+contentFromServer);
//                }
            }while(true);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                if(reader_keyboard != null){
                    reader_keyboard.close();
                    reader_keyboard = null;
                }
                if(socket != null){
                    socket.close();
                    socket = null;
                }
                if(writer != null){
                    writer.close();
                    writer = null;
                }
            } catch (IOException e) {
                // TODO: handle exception
            }
        }
    }

}