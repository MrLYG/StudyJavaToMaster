package com.lagou.controller;

import com.lagou.domain.QueryVo;
import com.lagou.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user") //一级访问目录
@SessionAttributes("username") //向request域中（model）中存入key为username时，会同步到session域中
public class UserController {


    // http://localhost:8080/springmvc_quickstart/user/quick    /一级访问目录/二级访问目录
    /*
        path :作用等同于value,同样是设置方法的映射地址
        method：用来限定请求的方式 RequestMethod.POST:只能以post的请求方式访问该访问，其他请求方式会报错
        params：用来限定请求参数的条件 params={"accountName"} 表示请求参数中必须有accountName
     */
    @RequestMapping(path = "/ ",method  = RequestMethod.GET,params = {"accountName"}) // 二级访问目录
    public String quick(Integer id){
        // 业务逻辑
        System.out.println("springmvc入门成功.....");
        // 视图跳转 逻辑视图名
        return "success";
    }


    /*
        获取基本类型请求参数
     */
    @RequestMapping("/simpleParam")
    public String simpleParam(Integer id,String username){

        System.out.println(id);
        System.out.println(username);

        return "success";
    }


    /*
        获取对象类型请求参数
     */
    @RequestMapping("/pojoParam")
    public String pojoParam(User user){
        System.out.println(user);
        return "success";
    }

    /*
        获取数组类型请求参数
     */
    @RequestMapping("/arrayParam")
    public String arrayParam(Integer[] ids){

        System.out.println(Arrays.toString(ids));
        return "success";

    }

    /*
        获取集合（复杂）类型请求参数
     */

    @RequestMapping("/queryParam")
    public String queryParam(QueryVo queryVo){
        System.out.println(queryVo);
        return "success";
    }

    /*
        获取日期类型参数：（自定义类型转换器）
     */
    @RequestMapping("/converterParam")
    public String converterParam(Date birthday){
        System.out.println(birthday);
        return "success";
    }



    /*
        演示@RequestParam注解
     */
    /*
        @RequestParam
            name: 匹配页面传递参数的名称
            defaultValue: 设置参数的默认值
            required:设置是否必须传递该参数，默认值为true,如果设置了默认值，值自动改为false
     */
    @RequestMapping("findByPage")
    public String findByPage(@RequestParam(name = "pageNo",defaultValue = "1",required = false)Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize){
        System.out.println(pageNum); //2
        System.out.println(pageSize); //5
        return "success";
    }

    /*
        @ReuqestHeader注解的使用
     */
    @RequestMapping("/RequestHeader")
    public String requestHead(@RequestHeader("cookie") String cookie){
        System.out.println(cookie);
        return "success";
    }

    /*
        @CookieValue注解的使用
     */
    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String jsessionId){
        System.out.println(jsessionId);
        return "success";
    }

    /*
        原始serlvetAPI的获取
     */
    @RequestMapping("/servletAPI")
    public String servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        // posthandler


        return "success";
    }

    /*
        通过原始servletAPI进行页面跳转
     */

    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*直接返回数据*/
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("拉勾网");


        // 借助request对象完成请求转发 一次请求
       //  request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 借助response对象完成重定向 两次请求 WEB-INF：安全目录：不允许外部请求直接访问该目录资源，只可以进行服务器内部转发
       // response.sendRedirect(request.getContextPath() + "/index.jsp");

    }

    /*
        演示forward关键字进行请求转发
     */
    @RequestMapping("/forward")
    public String forward(Model model){

        //还想在模型中设置一些值怎么做？
        model.addAttribute("username","拉勾招聘");
        // 使用请求转发，既可以转发到jsp,也可以转发到其他的控制器方法
        //return "forward:/product/findAll";
        return "forward:/WEB-INF/pages/success.jsp";
    }


    /*
        @SessionAttributes的效果：多个请求之间共享数据
     */
    @RequestMapping("/returnString")
    public String returnString(){
        return "success";
    }





    /*
        演示Redirect关键字进行重定向
         当写了redirect或者forward关键字，是不会再走视图解析器
         localhost:8080/项目路径/user/redirect
     */
    @RequestMapping("/redirect")
    public String redirect(Model model){
        // 底层使用的还是reqeust.setAttribute("username","拉勾教育") 域范围：一次请求
        model.addAttribute("username","拉勾教育");

        return "redirect:/index.jsp";
    }


    /*
        modelAndView进行页面跳转:方式一
     */

    @RequestMapping("/returnModelAndView")
    public ModelAndView returnModelAndView(){

        /*
            model:模型：作用封装存放数据
            View ：视图：用来展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据
        modelAndView.addObject("username","modelAndView方式一");

        // 设置视图名称 视图解析器解析modelAndView 拼接前缀和后后缀
        modelAndView.setViewName("success");

        return modelAndView;
    }


    /*
        modelAndView进行页面跳转:方式二

     */
    @RequestMapping("/returnModelAndView2")
    public ModelAndView returnModelAndView2(ModelAndView modelAndView){

        /*
            model:模型：作用封装存放数据
            View ：视图：用来展示数据
         */
        // 设置模型数据
        modelAndView.addObject("username","modelAndView方式二");

        // 设置视图名称 视图解析器解析modelAndView 拼接前缀和后后缀
        modelAndView.setViewName("success");

        return modelAndView;
    }



    /*
        ajax异步交互  [{"id":1,"username":"张三"},{"id":2,"username":"李四"}]
     */
    @RequestMapping("/ajaxRequest")
    @ResponseBody
    public List<User> ajaxRequest(@RequestBody List<User> list){
        System.out.println(list);
        return list;
    }








}
