package phase1.module4.Work.work01;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import phase1.module2.polymorphy.S;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentSystem {
    /**+
     *    a.使用 List 集合实现简易的学生信息管理系统，要求打印字符界面提示用户选择相应的功 能，
     *    根据用户输入的选择去实现增加、删除、修改、查找以及遍历所有学生信息的功能。
     *    b.自定义学号异常类和年龄异常类，并在该成员变量不合理时产生异常对象并抛出。
     *    c.当系统退出时将 List 集合中所有学生信息写入到文件中，当系统启动时读取文件中所 有学生信息到 List 集合中。
     */
    public static List<Student> students = new ArrayList<>(); //students 集合用于保存所有student的信息
    private String docIP = "d:/student.txt" ; //用于记录保存学生信息文件的地址默认为"d:/student.txt"
    private int id = 170000; //用于自动给学生分配id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


    //输入并增加增加一个学生信息
    public void addStu(){
        System.out.println("\\n开始添加一个学生信息");
        Student student = new Student();
        Scanner sc = new Scanner(System.in);

        id++;
        student.setsId(Integer.toString(id)); //自动分配id


        System.out.println("请输入学生的姓名:");
        student.setName(sc.next());
        System.out.println("请输入学生的性别:");
        student.setGender(sc.next());
        System.out.println("请输入学生的年龄:");
        student.setAge(sc.next());

        System.out.println("请输入学生的年级:");
        student.setGrade(sc.next());
        StudentSystem.students.add(student);
        System.out.println("学生"+student.toString()+"添加成功！");

    }


    //删除一个学生信息
    public void deleteStu() {
        System.out.println("\\n开始删除一个学生信息");
        Scanner sc = new Scanner(System.in);
        //构建待删除的学生信息
        Student student = new Student();
        System.out.println("请输入学生的ID:");
        student.setsId(sc.next());

        //通过迭代器，遍历学生信息集合，删除匹配的学生
        Iterator<Student> it = StudentSystem.students.iterator();
        while (it.hasNext()){
            Student stu = it.next(); //用于保存被删除学生的信息
            if(student.getsId().equals(stu.getsId())){
                System.out.println("学生"+stu+"已经删除");
                it.remove();
            }
        }
    }
    //修改一个学生信息
    public void revise(){
        System.out.println("开始修改一个学生信息");
        Scanner sc = new Scanner(System.in);
        //构建待修改的学生信息
        Student student = new Student();
        System.out.println("请输入学生的ID:");
        student.setsId(sc.next());
        Iterator<Student> it = StudentSystem.students.iterator();
        while (it.hasNext()){
            Student stu = it.next(); //用于保存被删除学生的信息
            if(student.getsId().equals(stu.getsId())){
                System.out.println(stu);
                int index = students.indexOf(stu); //获取元素的位置
                System.out.println("请输入修改后学生的姓名:");
                stu.setName(sc.next());
                System.out.println("请输入修改后学生的性别:");
                stu.setGender(sc.next());
                System.out.println("请输入修改后学生的年龄:");
                stu.setAge(sc.next());
                System.out.println("请输入修改后学生的年级:");
                stu.setGrade(sc.next());

                students.set(index,stu);//将修改的stu存入集合中
                System.out.println("学生"+stu+"已修改完毕");
            }
        }

    }

    //查找一个学生信息
    public void find(){
        System.out.println("开始查询一个学生信息");
        Scanner sc = new Scanner(System.in);
        //构建待查询的学生实体
        Student student = new Student();
        System.out.println("请输入学生的姓名:");
        student.setName(sc.next());
        //通过迭代器，遍历学生信息集合
        Iterator<Student> it = StudentSystem.students.iterator();
        while (it.hasNext()){
            Student stu = it.next(); //用于保存被删除学生的信息
            if(student.getName().equals(stu.getName())){
                System.out.println("所查询的学生信息为:"+stu);
            }
        }
    }
    //遍历学生信息
    public void itStus(){
        Iterator<Student> it = StudentSystem.students.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        StudentSystem ss = new StudentSystem();
        StudentSystem.students = ss.readAllStudentInfo(); //读取数据文件信息
        int size = StudentSystem.students.size();//用于保存 集合的大小
        ss.setId(Integer.valueOf(StudentSystem.students.get(size-1).getsId()));  //获取集合最后一个元素的ID，便于ID自增


        Scanner sc = new Scanner(System.in);
        int index;
        boolean flag = true;
        while (flag){
            ss.draw();
            index = sc.nextInt();
            switch (index){
                case 1:ss.addStu();break;
                case 2:ss.deleteStu();break;
                case 3:ss.revise();break;
                case 4:ss.find();break;
                case 5:ss.itStus();break;
                case 6:ss.close(); flag = false; break;
            }

        }
    }
}
