package lyg.servlet;

import lyg.enetity.Student;
import lyg.factory.EntityFactory;
import lyg.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李沅罡
 */
@WebServlet(name = "StudentListServlet",urlPatterns = "/studentList")
public class StudentListServlet extends HttpServlet {
    private StudentService studentService;

    public StudentListServlet() {
        this.studentService = EntityFactory.getStudentService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = null ;
        students = studentService.getAllStudents();
        request.setAttribute("students",students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
