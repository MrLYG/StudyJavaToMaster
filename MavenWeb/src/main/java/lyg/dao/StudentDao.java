package lyg.dao;

import lyg.enetity.Student;

import java.util.List;

/**
 * @author 李沅罡
 */
public interface StudentDao {
    List<Student> getAllStudents();

    Boolean revise(Student student);

    Boolean add(Student student);

    List<Student> searchStudent(Student s);

    Boolean delete(Student s);


}
