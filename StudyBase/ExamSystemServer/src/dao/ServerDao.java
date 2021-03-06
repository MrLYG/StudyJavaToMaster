package dao;
import entity.QuestionsBank;
import entity.Student;
import model.Message;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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
     * 校验管理员账号和密码
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
     * 校验学员账号和密码
     * @param user
     * @return
     */
    public boolean serverStudentCheck(User user) {
        List ss = new ArrayList(); //ss用于存放查询结果

        //通过迭代器，遍历学生信息集合
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            Student stu = it.next(); //用于保存被删除学生的信息
            if(user.getUserName().equals(stu.getId()) && user.getPassWord().equals(stu.getGender()+stu.getAge())){
                return true;
            }
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
        return;
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
        return;
    }

    /**
     * 自定义方法修改学员信息
     * @param student
     */
    public void reviseStudent(Student student) {
        Iterator<Student> it = students.iterator();
        int index = -1;
        while (it.hasNext()){
            Student stu = it.next(); //用于保存被删除学生的信息
            if(student.getSid().equals(stu.getSid())){
                index = students.indexOf(stu); //获取元素的位置
            }
        }
        if(index == -1) return;
        students.set(index,student);//将修改的stu存入集合中
        System.out.println(students);
        itStus();
        return;
    }
    //遍历学生信息
    public void itStus(){
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    public void closeStu() {
        writeStudentsInfo();
        return;
    }



}
