package phase1.module4.Work.work01;

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
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
