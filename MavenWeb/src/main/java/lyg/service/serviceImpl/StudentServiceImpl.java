package lyg.service.serviceImpl;

import lyg.dao.StudentDao;
import lyg.enetity.Student;
import lyg.factory.EntityFactory;
import lyg.service.StudentService;

import java.util.List;

/**
 * @author 李沅罡
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentServiceImpl() {
        this.studentDao = EntityFactory.getStudentDao();
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentDao.getAllStudents();
        return studentList;
    }

    @Override
    public Boolean revise(Student student) {
        Boolean flag = studentDao.revise(student);
        return flag;
    }

    @Override
    public Boolean add(Student student) {
        Boolean flag = studentDao.add(student);
        return flag;
    }

    @Override
    public List<Student> searchStudent(Student s) {
        List<Student> studentList = studentDao.searchStudent(s);
        return studentList;
    }

    @Override
    public Boolean delete(Student s) {
        Boolean flag = studentDao.delete(s);
        return flag;
    }
}
