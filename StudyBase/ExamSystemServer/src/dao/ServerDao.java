package dao;

import entity.Student;
import model.Message;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ServerDao {


    public static List<Student> students = new ArrayList<>();; //students 集合用于保存所有student的信息
    private static String docIP = "ExamSystemServer\\src\\dao\\studentM.txt" ; //用于记录保存学生信息文件的地址默认为"d:/studentM.txt"



    /**
     *
     *自定义静态方法，用于系统打开时，自动读取学员信息文件
     */
    {
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            File file = new File(docIP);
            ois = new ObjectInputStream(new FileInputStream(file ));
            obj = ois.readObject();
            students = (ArrayList)obj;
        } catch (EOFException e){   //若文件初始为空，则List集合指向null
            students = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
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
    }


    /***
     * 校验账号和密码
     * @param user
     * @return
     */
    public boolean serverManagerCheck(User user){
        if("admin".equals(user.getUserName())&&"123456".equals(user.getPassWord())){
            return true;
        }
        return false;
    }




    /**
     * 自定义方法用于添加学生
     * @param student
     */
    public void addStudent(Student student) {
        students.add(student);
        System.out.println(students);
    }

    //查找一个学生信息
    public List<Student> findStus(Student student){

        List ss = new ArrayList(); //ss用于存放查询结果

        //通过迭代器，遍历学生信息集合
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            Student stu = it.next(); //用于保存被删除学生的信息
            if(student.getName().equals(stu.getName())){
                ss.add(stu);
            }
        }
        return ss;
    }

//    //删除一个学生信息
//    public void deleteStu(Message o) {
//        System.out.println("\\n开始删除一个学生信息");
//        Scanner sc = new Scanner(System.in);
//        //构建待删除的学生信息
//        Student student = new Student();
//        System.out.println("请输入学生的ID:");
//        student.setsId(sc.next());
//
//        //通过迭代器，遍历学生信息集合，删除匹配的学生
//        Iterator<Student> it = StudentSystem.students.iterator();
//        while (it.hasNext()){
//            Student stu = it.next(); //用于保存被删除学生的信息
//            if(student.getsId().equals(stu.getsId())){
//                System.out.println("学生"+stu+"已经删除");
//                it.remove();
//            }
//        }
//    }

    /**
     * 将list集合中所有信息写入到文件中
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
     * 自定义方法删除学员信息
     * @param student
     */
    public void deleteStu(Student student) {
        //通过迭代器，遍历学生信息集合，删除匹配的学生
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            Student stu = it.next(); //用于保存被删除学生的信息
            if(student.getSid().equals(stu.getSid())){
                System.out.println("学生"+stu+"已经删除");
                it.remove();
            }
        }
    }

    /**
     * 自定义方法修改学员信息
     * @param student
     */
    public void reviseStudent(Student student) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            Student stu = it.next(); //用于保存被删除学生的信息
            if(student.getSid().equals(stu.getSid())){
                System.out.println(stu);
                int index = students.indexOf(stu); //获取元素的位置
                stu.setName(student.getName());
                stu.setGender(student.getGender());
                stu.setAge(student.getAge());
                students.set(index,stu);//将修改的stu存入集合中
                System.out.println("学生"+stu+"已修改完毕");
            }
        }
    }

    public void closeStu() {
        writeStudentsInfo();
    }
}
