package test;

import org.csource.common.MyException;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * @Author: Ken
 * @Date: 2021/6/7 13:15
 */
public class TestUpload {
    public static void main(String[] args) throws IOException, MyException {

        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();

        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);

        NameValuePair[] list = new NameValuePair[1];
        list[0] = new NameValuePair("fileName","1.pdf");
//        group1/M00/00/00/wKjplGC9rQ6AI7ZOAAof71Ty-qI330.pdf
        String fileID = client.upload_file1("E:\\important\\学习\\软件缺陷自动修复技术综述.pdf", "pdf", list);
        System.out.println(fileID);
        trackerServer.close();


    }
}
