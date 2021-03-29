package com.example.httpclienttest;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class HttpClientTest implements Runnable{
//"http://192.168.8.115:1234/upload"


//    @Test
//    public void test() throws InterruptedException {
//
//
//        //关闭连接
//    }
    /**
     * 上传文件
     * 1.filePath: 所需上传的文件目录 2. fileNo 文件编号
     * @param url
     * @param
     * @return
     */
    public static void uploadFile(String url , File file , String fileNo){
        System.out.println("--------------开始上传文件doPost--------------");
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();

            //以浏览器兼容模式运行，防止文件名乱码。
            multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

            FileBody fileBody = new FileBody(file);
            StringBody uploadFileNo =new StringBody(
                    fileNo, ContentType.create("text/plain", Consts.UTF_8));
            multipartEntityBuilder.addPart("file",fileBody);
            multipartEntityBuilder.addPart("fileNo",uploadFileNo);
            multipartEntityBuilder.setCharset(CharsetUtils.get("UTF-8"));

            //创建一个HttpEntity。
            HttpEntity reqEntity = multipartEntityBuilder.build();

            //创建HttpPost请求，并交付url
            HttpPost httpPost =new HttpPost( url );

            //将参数交付给HttpPost请求体
            httpPost.setEntity(reqEntity);

            httpClient = HttpClients.createDefault();
            // 发起请求 并返回请求的响应
            response = httpClient.execute(httpPost);

            System.out.println("----------------------------------------");
            // 打印响应状态
            System.out.println(response.getStatusLine());
            // 获取响应对象
            HttpEntity resEntity = response.getEntity();
            if(resEntity !=null) {
                // 打印响应长度
                System.out.println("Response content length: "
                        + resEntity.getContentLength());
                // 打印响应内容
                System.out.println(EntityUtils.toString(resEntity, Charset.forName("UTF-8")));
            }
            // 销毁
            EntityUtils.consume(resEntity);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if(null!=response){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=httpClient){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void run() {

//        File pdfFile = new File("D:\\GRE备考\\GRE阅读\\XDF\\2021版GREfo脚阅读400系列-Volume 1-阅读机经篇.pdf");
        File pdfFile = new File("/home/liyuangang/pdfTest.pdf");
        uploadFile("http://192.168.8.115:1234/upload", pdfFile, ""+System.currentTimeMillis());
    }
}
