package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 创建学员类
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 5123178131729916261L;
    private String sid;  //学生id
    private String name;
    private String gender;
    private String age;

    public Student(String name) {
        this.name = name;
    }

    public Student(String sid, String name, String gender, String age) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Student() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sid, student.sid) &&
                Objects.equals(name, student.name) &&
                Objects.equals(gender, student.gender) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, name, gender, age);
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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
}
