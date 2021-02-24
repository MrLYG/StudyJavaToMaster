package phase1.module4.Work;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File f1 = new File("d:/file.txt");
        if(f1.exists()){
            System.out.println("fileName is : " + f1.getName());
            System.out.println("the size of file is : " + f1.length());
            Date d1 = new Date(f1.lastModified());
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
            System.out.println(sdf.format(d1));
            System.out.println("the last time of revising is : " + f1.lastModified());
            System.out.println("the absolute path of file is : " + f1.getAbsolutePath());
//            System.out.println( f1.delete() ? "delete success " : " delete failed");
        }else {
            System.out.println( f1.createNewFile() ? "create success" : "create failed");
        }


        //目录的删除和创建


        File f2 = new File("d:/dir/dir2/dir3");
        if(f2.exists()){
            System.out.println("the fir name is : " + f2.getName());
//            System.out.println(f2.delete() ? "delete success" : "delete failed");  //只能删除空目录
        }else {
            System.out.println(f2.mkdirs() ? "create success" : "create failed");
        }


        //获取指定目录下的所有内容

        File[] filesArray = new File("d:/").listFiles();
        // 遍历数组
        for (File tf: filesArray) {
            String name = tf.getName();
            // 判断是否为文件，若是则直接打印文件名称
            if (tf.isFile()) {
                System.out.println(name);
            }
            // 若是目录，则使用[]将目录名称括起来
            if (tf.isDirectory()) {
                System.out.println("[" + name + "]");
            }
        }

        System.out.println("---------------------------------------------------------");
        //使用listFiles(FileFilter filter) 获取目录下满足筛选器的所有内容
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };
        FileFilter ff = (File pathname) -> { return pathname.getName().endsWith(".txt"); };
        File[] filesArray2 = new File("d:/").listFiles(fileFilter);
        for (File tf : filesArray2 ) {
            System.out.println(tf);
        }

        System.out.println("---------------------------------------------------------");
        //实现指定目录以及子目录中所有的内容的
        showAll(new File("d:/dir"));

        System.out.println("---------------------------------------------------------");
     


//        int[][] aa = {{1,-129,3},{1,-129,4},{1,199,2},{1,199,8},{1,199,8}};
//        for (int[] a: aa) {
//            for (int x :a ) {
//                System.out.print(System.identityHashCode(x)+"--");
//            }
//            System.out.println();
//            System.out.println(a.hashCode());
//            System.out.println(System.identityHashCode(a));;
//            System.out.println(Arrays.toString(a));
//        }

    }


    //实现指定目录以及子目录中所有的内容的
    public static void showAll(File file){
        File[] filesArray = file.listFiles();
        // 遍历数组
        for (File tf: filesArray) {
            String name = tf.getName();
            // 判断是否为文件，若是则直接打印文件名称
            if (tf.isFile()) {
                System.out.println(name);
            }
            // 若是目录，则使用[]将目录名称括起来
            if (tf.isDirectory()) {
                System.out.println("[" + name + "]");
                showAll(tf);
            }
        }
    }



}
