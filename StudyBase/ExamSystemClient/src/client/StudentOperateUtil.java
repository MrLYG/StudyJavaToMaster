package client;

import entity.Student;
import model.Message;
import model.User;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 自定义类，实现学员相关操作
 */
public class StudentOperateUtil {
    public void addStu(ClientInitClose cic) throws IOException {
        System.out.println("请输入学号");
        String id = ClientScanner.getSc().next();
        System.out.println("请输入姓名");
        String name = ClientScanner.getSc().next();
        System.out.println("请输入性别");
        String gender = ClientScanner.getSc().next();
        System.out.println("请输入年龄");
        String age = ClientScanner.getSc().next();
        Student s = new Student(id,name,gender,age);
        Message m = new Message("addStudent", s);
        cic.getOos().writeObject(m);
        System.out.println("学员添加成功！");
        return;
    }

    public void findStus(ClientInitClose cic) throws IOException, ClassNotFoundException {
        System.out.println("请输入学生的姓名:");
        Student s = new Student(ClientScanner.getSc().next());
        Message m = new Message("findStus", s);
        cic.getOos().writeObject(m);

        //接受服务端发来的消息
        Message resM = (Message) cic.getOis().readObject();

        if("success".equals(resM.getType())){
            System.out.println("查询成功！");
        }else {
            System.out.println("查询失败请联系管理员！");
        }
        List res = (List) resM.getT();
        //通过迭代器，遍历学生信息集合
        System.out.println("所查询的学生信息为:");
        Iterator<Student> it = res.iterator();
        while (it.hasNext()){
            Student stu = it.next(); //用于保存被删除学生的信息
            System.out.println(stu);
        }
        return;
    }

    /**
     * 客户端删除学员信息方法，用于和服务端通信，告知服务端删除什么对象
     * @param cic
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void deleteStu(ClientInitClose cic) throws IOException, ClassNotFoundException {
        System.out.println("\\n开始删除一个学生信息");
        System.out.println("请输入学生的ID:");
        Student s = new Student();
        s.setSid(ClientScanner.getSc().next());
        Message m = new Message("deleteStu", s);
        //给服务端发送删除指令，并传递删除对象
        cic.getOos().writeObject(m);


        //接受服务端发来的消息
        Message resM = (Message) cic.getOis().readObject();

        if("success".equals(resM.getType())){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败请联系管理员！");
        }
        return;
    }

    /**
     * 客户端修改学员信息方法，用于和服务端通信，告知服务端修改什么对象
     * @param cic
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void reviseStu(ClientInitClose cic) throws IOException, ClassNotFoundException {
        System.out.println("请安一下指导完成输入，进行学员信息修改");
        System.out.println("请输入学号");
        String id = ClientScanner.getSc().next();
        System.out.println("请输入姓名");
        String name = ClientScanner.getSc().next();
        System.out.println("请输入性别");
        String gender = ClientScanner.getSc().next();
        System.out.println("请输入年龄");
        String age = ClientScanner.getSc().next();
        Student s = new Student(id,name,gender,age);
        Message m = new Message("reviseStudent", s);
        cic.getOos().writeObject(m);
        System.out.println("学员修改成功！");
        return;






    }

    /**
     * 关闭成员管理子系统，并保存数据
     * @param cic
     * @throws IOException
     */
    public void closeStu(ClientInitClose cic) throws IOException {
        Message m = new Message("closeStu", "");
        cic.getOos().writeObject(m);
    }
}
