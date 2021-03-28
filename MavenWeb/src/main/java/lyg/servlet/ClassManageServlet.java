package lyg.servlet;

import lyg.enetity.ClassInfo;
import lyg.enetity.Student;
import lyg.factory.EntityFactory;
import lyg.service.ClassInfoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassManageServlet" , urlPatterns = "/classManage")
public class ClassManageServlet extends HttpServlet {
    private ClassInfoService classInfoService= null;


    public ClassManageServlet() {
        this.classInfoService = EntityFactory.getClassInfoService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cmd = request.getParameter("cmd");

        if("showClazzes".equalsIgnoreCase(cmd)){
            String f = request.getParameter("f");
            if(f!=null){
                request.setAttribute("f",f);
            }
            int count = classInfoService.getCountofClass();
            request.getSession().setAttribute("ClassCount",count);
            String pageNo = request.getParameter("pageNo");
            List<ClassInfo> classInfoList = null;
            classInfoList = classInfoService.getClassInfoByPage(pageNo);
//            request.getSession().setAttribute("classInfoList",classInfoList);
            request.setAttribute("classInfoList",classInfoList);
            request.getRequestDispatcher("classManage.jsp").forward(request,response);
        }else if("add".equalsIgnoreCase(cmd)){

            String className = request.getParameter("className");
            String grade = request.getParameter("grade");
            String homeTeacherName = request.getParameter("homeTeacherName");
            String classNum = request.getParameter("classNum");
            String classSlogan = request.getParameter("classSlogan");
            ClassInfo classInfo = new ClassInfo(className,grade,homeTeacherName,classNum,classSlogan);
            Boolean flag = classInfoService.add(classInfo);
            if(flag){
                response.sendRedirect("/MavenWeb/classManage?cmd=showClazzes&pageNo=1");
            }
        }else if("delete".equalsIgnoreCase(cmd)){

            String classId = request.getParameter("classId");

            //先判断是否该classid是否和学生有关联
            ClassInfo classInfo1 = new ClassInfo();
            classInfo1.setClassId(classId);
            Boolean f = classInfoService.isHaveForeignClass(classInfo1);
            if(f){

                response.sendRedirect("/MavenWeb/classManage?cmd=showClazzes&pageNo=1&f=0");
            }else {
                ClassInfo classInfo = new ClassInfo();
                classInfo.setClassId(classId);
                Boolean flag = classInfoService.delete(classInfo);
                if(flag){
                    response.sendRedirect("/MavenWeb/classManage?cmd=showClazzes&pageNo=1");
                }
            }

        }else if("search".equalsIgnoreCase(cmd)){
            String classNmae = request.getParameter("className");
            ClassInfo classInfo = new ClassInfo();
            classInfo.setClassName(classNmae);
            List<ClassInfo> classInfos = null ;
            classInfos = classInfoService.searchclassInfos(classInfo);
            request.setAttribute("classInfos",classInfos);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchClassInfo.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
