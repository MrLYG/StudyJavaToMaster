package phase1.module4.Work.io;

import java.io.*;

public class PrintStreamChatTest {
    public static void main(String[] args) {
        BufferedReader br = null;     //可以用readLine()读取一行
        BufferedInputStream bufferedInputStream = null;
        PrintStream ps =  null;

        try {
            // 由手册可知：构造方法需要的是Reader类型的引用，但Reader类是个抽象类，实参只能传递子类的对象  字符流
            // 由手册可知： System.in代表键盘输入， 而且是InputStream类型的 字节流
//            br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/a.txt")));
            br = new BufferedReader(new InputStreamReader(System.in));
//            bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/a.txt"));
            ps = new PrintStream(new FileOutputStream("d:/a.txt"));
            String str = null;
            while (!"bye".equalsIgnoreCase(str)) {
                str = br.readLine();
                //int str = bufferedInputStream.read();
                ps.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != ps){
                ps.close();
            }
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
