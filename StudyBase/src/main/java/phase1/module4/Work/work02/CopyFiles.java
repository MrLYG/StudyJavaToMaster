package phase1.module4.Work.work02;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CopyFiles {
    private static String formDir;
    private static String toDir;
    //创建服务，创建线程池
    public static ExecutorService service = null;
    /**
     *     2. 编程题
     *     a. 使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。
     *     b.实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。
     */
    public static void copy(){
        service = Executors.newFixedThreadPool(10);

        //输入需要拷贝的目录
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入拷贝的源文件目录路径(例如f: or f:/dir):");
        formDir= sc.next();
        File srcFiles = new File(formDir);
        System.out.println("请输入拷贝的目标文件目录路径(例如f: or f:/dir):");
        toDir= sc.next();

        //判断文件路径是否合法
        while(!toDir.contains(":")){
            System.out.println("该文件目录不合法，请重新输入文件路径(例如f: or f:/dir)");
            toDir= sc.next();
        }

        //根据后边逻辑需要，将文件目录路径结尾的/去掉
        if('\\' == toDir.charAt(toDir.length()-1) || '/' == toDir.charAt(toDir.length()-1) ){
            toDir.substring(0,toDir.length()-2);
            System.out.println(toDir);
        }

        File toFiles = new File(toDir);
        if(!toFiles.exists()){
            System.out.println("文件不存在于系统中，已为您创建！");
            System.out.println(toFiles.mkdirs() ? "create success" : "create failed");
        }
        copydir(srcFiles);
        copyAllFiles(srcFiles);
        service.shutdown();
    }
    public static void main(String[] args) {
        Boolean flag = true;

        String index = null;
        Scanner sc = new Scanner(System.in);

        while(flag){
            System.out.println("a. 使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。");
            System.out.println("b.实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。");
            System.out.println("请输入想实现功能对应的[小写]字母(a 或 b),结束请输入 bye");
            index = sc.next();
            switch (index){
                case "a":copy();break;
                case "b":;break;
                case "bye":flag = false;
                    System.out.println("bye,bye!");break;
            }
        }
    }

    //先拷贝目录
    public static void copydir(File file){
        File[] filesArray = file.listFiles();
        for (File tf: filesArray) {
            String name = tf.getName();
            // 若是目录，创建目录
            if (tf.isDirectory()) {
                System.out.println("[" + name + "]");
                int index = tf.getAbsolutePath().indexOf(formDir);
                String absolutePath = tf.getAbsolutePath().substring(formDir.length());
                absolutePath = absolutePath.replaceAll("\\\\","/");
                File newFile = new File(toDir+absolutePath);
                //若文件目录不存在，则创建目录
                if(!newFile.exists()){
                    newFile.mkdirs();
                }

                copydir(tf);
            }
        }
    }

    //拷贝所有文件
    public static void copyAllFiles(File file){
        File[] filesArray = file.listFiles();
        // 遍历数组
        for (File tf: filesArray) {
            String name = tf.getName();
            // 判断是否为文件，若是则直接将文件复制到本项目下
            if (tf.isFile()) {
                //获取该文件的绝对目录
                int index = tf.getAbsolutePath().indexOf(formDir);
                String absolutePath = tf.getAbsolutePath().substring(formDir.length());

                CopyThread copyThread = new CopyThread(tf.getAbsolutePath(),toDir + absolutePath);
                service.execute(copyThread);

            }
        }
    }

}


class CopyThread implements Runnable{
    private String fromFile;
    private String toFile;


    public CopyThread(String formDir, String toDir) {
        this.fromFile = formDir;
        this.toFile = toDir;
    }

    //将文件A 的内容复制到文件B
    @Override
    public void run() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        fromFile = fromFile.replaceAll("\\\\","/");
        toFile = toFile.replaceAll("\\\\","/");
        System.out.println(Thread.currentThread().getName()+"..........."+fromFile);
        System.out.println(Thread.currentThread().getName()+"..........."+toFile);
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
}