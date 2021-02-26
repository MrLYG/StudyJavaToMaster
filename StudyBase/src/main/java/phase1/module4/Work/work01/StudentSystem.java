package phase1.module4.Work.work01;

import phase1.module2.polymorphy.S;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentSystem {
    public static List<Student> students = new ArrayList<>(); //students 集合用于保存所有student的信息
    private String docIP = "d:/student.txt" ; //用于记录保存学生信息文件的地址默认为"d:/student.txt"
    /**+
     *    a.使用 List 集合实现简易的学生信息管理系统，要求打印字符界面提示用户选择相应的功 能，
     *    根据用户输入的选择去实现增加、删除、修改、查找以及遍历所有学生信息的功能。
     *    b.自定义学号异常类和年龄异常类，并在该成员变量不合理时产生异常对象并抛出。
     *    c.当系统退出时将 List 集合中所有学生信息写入到文件中，当系统启动时读取文件中所 有学生信息到 List 集合中。
     */

    /**
     * 将lsit集合中所有信息写入到文件中
     */
    public void writeStudentsInfo(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(docIP));
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != oos){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 读取文件中所有学生信息
     * @return  所有学生信息
     */
    public ArrayList<Student> readAllStudentInfo(){
        File file = new File(docIP);
        if(!file.exists()){
            return null ; //返回为空 代表目前还没有存储学生信息的文件
        }
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(docIP));
            obj = ois.readObject();
            return (ArrayList)obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void draw(){
        System.out.println("*************************************");
        System.out.println("***-----------1.增加--------------***");
        System.out.println("***-----------2.删除--------------***");
        System.out.println("***-----------3.修改--------------***");
        System.out.println("***-----------4.查找--------------***");
        System.out.println("***-----------5.遍历--------------***");
        System.out.println("***-----------6.关闭系统-----------***");
        System.out.println("***----(终止程序将会导致数据丢失)-----***");
        System.out.println("***       请输入功能对应的编         ***");
        System.out.println("*************************************");

    }
    public void close(){
        this.writeStudentsInfo();
    }

    public static void main(String[] args) {
        StudentSystem ss = new StudentSystem();
        List judgeList = ss.readAllStudentInfo();
        if(judgeList == null){
            System.out.println("目前还没有数据库文件");
        }else {
            StudentSystem.students = ss.readAllStudentInfo();
            System.out.println(StudentSystem.students);
        }

        ss.draw();
        StudentSystem.students.add(new Student());
        StudentSystem.students.add(new Student());
        System.out.println(StudentSystem.students.size());

        ss.close();
    }
}
