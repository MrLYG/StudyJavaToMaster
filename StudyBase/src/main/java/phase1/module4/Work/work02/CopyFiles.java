package phase1.module4.Work.work02;

import java.io.*;
import java.util.Scanner;

public class CopyFiles {
    /**
     *     2. 编程题
     *     a. 使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。
     *     b.实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。
     */


    public static void main(String[] args) {
        //输入需要拷贝的目录
        Scanner sc = new Scanner(System.in);
        String srcFilesPath = sc.next();
        File srcFiles = new File(srcFilesPath);
//        File srcFiles = new File("d:/file.txt");


//        File[] filesArray = srcFiles.listFiles();
        showAllFiles(srcFiles);

        //将目录转存到本项目下，便于拷贝时访问



        //拷贝
    }

    //将文件A 的内容复制到文件B
    public static void copyFilesImpl(String fromFile, String toFile){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        fromFile = fromFile.replaceAll("\\\\","/");
        toFile = toFile.replaceAll("\\\\","/");
        System.out.println(fromFile);
        System.out.println(toFile);
        try {
            // 1.创建BufferedInputStream类型的对象与fromFile文件关联
            bis = new BufferedInputStream(new FileInputStream(fromFile));
            // 2.创建BufferedOuputStream类型的对象与toFile文件关联
            bos = new BufferedOutputStream(new FileOutputStream(toFile));

            // 3.不断地从输入流中读取数据并写入到输出流中
            System.out.println("正在玩命地拷贝...");
            byte[] bArr = new byte[1024];
            int res = 0;
            while ((res = bis.read(bArr)) != -1) {
                bos.write(bArr, 0, res);
            }

            System.out.println("拷贝文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流对象并释放有关的资源
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void showAllFiles(File file){
        String formDir ="d:/dir";
        String toDir = "F:/fdir";

        File[] filesArray = file.listFiles();
        // 遍历数组
        for (File tf: filesArray) {
            String name = tf.getName();
            // 判断是否为文件，若是则直接将文件复制到本项目下
            if (tf.isFile()) {

                //获取该文件的绝对目录
                int index = tf.getAbsolutePath().indexOf(formDir);
                String absolutePath = tf.getAbsolutePath().substring(formDir.length());
                System.out.println(absolutePath);
                copyFilesImpl(tf.getAbsolutePath(),toDir + absolutePath);

            }
            // 若是目录，则使用[]将目录名称括起来
            if (tf.isDirectory()) {
                System.out.println("[" + name + "]");
                int index = tf.getAbsolutePath().indexOf(formDir);
                String absolutePath = tf.getAbsolutePath().substring(formDir.length());


                absolutePath = absolutePath.replaceAll("\\\\","/");
                System.out.println(toDir+absolutePath);
                File newFile = new File(toDir+absolutePath);

                //若文件目录不存在，则创建目录
                if(!newFile.exists()){
                    newFile.mkdirs();
                }

                showAllFiles(tf);
            }
        }
    }

}
