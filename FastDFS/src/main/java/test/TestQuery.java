package test;

import org.csource.fastdfs.*;

/**
 * @Author: Ken
 * @Date: 2021/6/7 13:28
 */
public class TestQuery {
    public static void main(String[] args) throws Exception {

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

        FileInfo fileInfo = client.query_file_info1("group1/M00/00/00/wKjplGC9rQ6AI7ZOAAof71Ty-qI330.pdf");
        if (fileInfo != null) {
            System.out.println("fileInfo = " + fileInfo);
        } else {
            System.out.println("查无此文件！");
        }
        trackerServer.close();

    }
}
