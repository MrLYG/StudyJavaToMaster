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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/studentServlet")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    public StudentServlet() {
        this.studentService = EntityFactory.getStudentService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cmd = request.getParameter("cmd");
        if("revise".equalsIgnoreCase(cmd)){
            String id = request.getParameter("studentid");
            List<Student> students = studentService.getAllStudents();
            Student targetStudent = null;
            for (Student s:students) {
                if(id.equalsIgnoreCase(s.getsId())){
                    targetStudent = s;
                }
            }
            request.setAttribute("student",targetStudent);
            request.getRequestDispatcher("reviseStudentInfo.jsp").forward(request,response);
        }else if("reviseUpdate".equalsIgnoreCase(cmd)){
            String sId = request.getParameter("sId");
            String sName = request.getParameter("sName");
            String sGender = request.getParameter("sGender");
            String sBorn = request.getParameter("sBorn");
            String sEmail = request.getParameter("sEmail");
            Student student = new Student(sId,sName,sGender,sBorn,sEmail);
            Boolean flag = studentService.revise(student);
            if(flag){
                response.sendRedirect("/MavenWeb/studentList");
            }
            System.out.println(sName);
        }else if("add".equalsIgnoreCase(cmd)){
            response.sendRedirect("addStudent.jsp");
        }else if("addStudent".equalsIgnoreCase(cmd)){
            String sId = request.getParameter("sId");
            String sName = request.getParameter("sName");
            String sGender = request.getParameter("sGender");
            String sBorn = request.getParameter("sBorn");
            String sEmail = request.getParameter("sEmail");
            Student student = new Student(sId,sName,sGender,sBorn,sEmail);
            Boolean flag = studentService.add(student);
            if(flag){
                response.sendRedirect("/MavenWeb/studentList");
            }
            System.out.println(sName);
        }else if("search".equalsIgnoreCase(cmd)){
            String sName = request.getParameter("sName");
            Student s = new Student();
            s.setsName(sName);
            List<Student> students = null ;
            students = studentService.searchStudent(s);
            request.setAttribute("students",students);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("StudentManage.jsp");
            requestDispatcher.forward(request,response);
        }else if("delete".equalsIgnoreCase(cmd)){
            String sId = request.getParameter("sId");
            Student s = new Student();
            s.setsId(sId);
            Boolean flag = studentService.delete(s);
            if(flag){
                response.sendRedirect("/MavenWeb/studentList");
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
