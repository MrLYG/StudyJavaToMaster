package per.lyg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import per.lyg.domain.Dept;
import per.lyg.service.DeptService;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/findAll")
    public  String findAll(Model model){

        //实现查询所有部门
        List<Dept> list = deptService.findAll();

        // 把封装好的list存到model中
        model.addAttribute("list",list);

        return "deptshows";

    }
}
