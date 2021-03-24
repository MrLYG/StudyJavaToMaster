package lyg.service;

import lyg.enetity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Boolean revise(Student student);

    Boolean add(Student student);

    List<Student> searchStudent(Student s);

    Boolean delete(Student s);
}
