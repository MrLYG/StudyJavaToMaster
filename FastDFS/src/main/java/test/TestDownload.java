package test;

import org.csource.fastdfs.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author: Ken
 * @Date: 2021/6/7 13:26
 */
public class TestDownload {
    public static void main(String[] args) throws Exception{
        // 加载配置文件
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        // 创建tracker客户端
        TrackerClient trackerClient = new TrackerClient();
        // 通过tracker客户端获取tracker的连接服务并返回
        TrackerServer trackerServer = trackerClient.getConnection();
        // 声明storage服务
        StorageServer storageServer = null;
        // 定义storage客户端
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);

        byte[] bytes = client.download_file1("group1/M00/00/00/wKjplGC9rQ6AI7ZOAAof71Ty-qI330.pdf");

        // 通过io将字节数组，转换成一个文件
        FileOutputStream fileOutputStream = new FileOutputStream(new File("F:/wKjplGC9rQ6AI7ZOAAof71Ty-qI330.pdf"));
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        trackerServer.close();
        System.out.println("下载完毕！");
    }
}
