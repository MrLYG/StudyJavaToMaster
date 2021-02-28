package phase1.module4.Work.work01;

import phase1.module4.teach.exceptionAndFiles.AgeException;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = -8299167070514236079L;
    private String sId; //学生学号
    private String name;
    private String gender;
    private String age;
    private String grade; //年级

    public Student() {
    }

    public Student(String sId, String name, String gender, String age, String grade) {
        this.sId = sId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        if (Integer.valueOf(age)> 0 && Integer.valueOf(age) < 150) {
            this.age = age;
        } else {
            System.out.println("年龄范围区间为（0,150）,因为输入超出范围，年龄系统自定为0，稍后可以通过修改操作，修改年龄！！！");
            try {
                throw new phase1.module4.teach.exceptionAndFiles.AgeException("年龄异常");
            } catch (AgeException e) {
                e.printStackTrace();
            }
        }
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
