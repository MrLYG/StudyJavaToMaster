package controller;

import entity.FileSystem;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: lagou-imageServer
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-29 14:25
 * @Description: 处理上传文件的控制器
 */
@Controller
public class FileAction {

    /**
     * @param request 多部件表单的请求对象
     * @return 上传文件对象的json对象
     * @throws Exception
     *
     * 上传文件的流程：
     * 1、先把文件保存到web服务器上
     * 2、再从web服务器上将文件 上传 到 FastDFS上
     */
    @Autowired
    private Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("upload")
    //MultipartHttpServletRequest：是httpservletRequest的强化版本，不仅可以装文本信息，还可以装图片文件信息
    public @ResponseBody synchronized FileSystem upload(MultipartHttpServletRequest request) throws Exception {
        // 定义商品id
        String productKey = "picture";
        // 通过redisson获取锁
        RLock rLock = redisson.getLock(productKey); // 底层源码就是集成了setnx，过期时间等操作
        // 上锁（过期时间为30秒）
        rLock.lock(30, TimeUnit.SECONDS);

        FileSystem fileSystem = new FileSystem();
        try{
            /* 1、把文件保存到web服务器*/
            // 从页面请求中，获取上传的文件对象
            MultipartFile file = request.getFile("fname");
            // 从文件对象中获取 文件的原始名称
            String oldFileName = file.getOriginalFilename();
            // 通过字符串截取的方式，从文件原始名中获取文件的后缀   1.jpg
            String hou = oldFileName.substring(oldFileName.lastIndexOf(".") + 1);
            // 为了避免文件因为同名而覆盖，生成全新的文件名
            String newFileName = UUID.randomUUID().toString() + "." + hou;
            // 创建web服务器保存文件的目录(预先创建好D:/upload目录，否则系统找不到路径，会抛异常)
            File toSaveFile = new File("D:/upload/" + newFileName);
            // 将路径转换成文件
            file.transferTo(toSaveFile);
            // 获取服务器的绝对路径
            String newFilePath = toSaveFile.getAbsolutePath();

            /* 2、把文件从web服务器上传到FastDFS*/

            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = null;
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);

            NameValuePair[] list = new NameValuePair[1];
            list[0] = new NameValuePair("fileName",oldFileName);
            String fileId = client.upload_file1(newFilePath, hou, list);
            trackerServer.close();

            // 封装fileSystem数据对象
            fileSystem.setFileId(fileId);
            fileSystem.setFileName(oldFileName);
            fileSystem.setFilePath(fileId);  //已经上传到FastDFS上，通过fileId来访问图片，所以fileId即为文件路径
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 释放锁
            rLock.unlock();
        }
        System.out.println(fileSystem.getFilePath()+"文件存入");
        return  fileSystem;
    }

    @Bean
    public Redisson redisson(){
        Config config = new Config();
        // 使用单个redis服务器
        config.useSingleServer().setAddress("redis://192.168.233.148:6379").setDatabase(0);
        // 使用集群redis
        // config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://192.168.204.141:6379","redis://192.168.204.142:6379","redis://192.168.204.143:6379");
        return (Redisson)Redisson.create(config);
    }
}
