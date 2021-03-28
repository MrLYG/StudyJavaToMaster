package lyg.servlet;

import lyg.enetity.Manager;
import lyg.factory.EntityFactory;
import lyg.service.ManagerService;
import lyg.service.serviceImpl.ManagerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 李沅罡
 */
@WebServlet(name="ManagerLoginServlet",urlPatterns="/managerLogin")
public class ManagerLoginServlet extends HttpServlet {
    private ManagerService managerService;

    public ManagerLoginServlet() {
        this.managerService = EntityFactory.getManagerService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        System.out.println("获取到的用户名为：" + userName);
        String password = request.getParameter("password");
        System.out.println("获取到的密码为：" + password);

        Manager m = new Manager(userName,password);
        Manager resM = managerService.login(m);
        if(resM!=null){
            System.out.println(userName);
            System.out.println(password);
            HttpSession httpSession = request.getSession();
            httpSession.setMaxInactiveInterval(10080);
            httpSession.setAttribute("Manager",resM);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/studentList");
            requestDispatcher.forward(request,response);
        }else {
            System.out.println("用户或密码错误");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
