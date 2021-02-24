import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Service implements Runnable{

    private Socket socket;
    private String hostName;
    private BufferedReader reader;
    private PrintWriter writer;

    public Service(Socket socket) {
        super();
        this.socket = socket;
        //通过socket获取客户端主机名
        hostName = socket.getInetAddress().getHostName();
        try {
            //读取客户端消息
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //给客户端发送消息
            writer = new PrintWriter(socket.getOutputStream(),true);
            System.out.println(hostName+"已上线！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        // TODO Auto-generated method stub
        String content = null;
        try {
            while((content=reader.readLine())!=null){
                if(content.equals("over")){
                    System.out.println(hostName+"已下线！");
                    break;
                }
                StringBuffer buffer = new StringBuffer(content);
                writer.println(buffer.reverse().toString());
                System.out.println(hostName+"说："+content);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                if(reader != null){
                    reader.close();
                    reader = null;
                }
                if(socket != null){
                    socket.close();
                    socket = null;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}