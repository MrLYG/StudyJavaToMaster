package dao;

import java.io.Serializable;
import java.util.Objects;

/**
 * 创建学员类
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 5123178131729916261L;
    private String id;  //学生id
    private String name;
    private String gender;
    private String age;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(gender, student.gender) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
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

    public Student(String id, String name, String gender, String age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
