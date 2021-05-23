package com.lagou.controller;


import org.springframework.web.bind.annotation.*;

@RestController //组合主键：组合@Controller + @ResponseBody
@RequestMapping("/restful")
public class RestfulController {

    /*
        根据id进行查询
        localhost:8080/项目名/restful/user/2 + get请求方式  404  findById:2
     */

    @GetMapping("/user/{id}") // @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable Integer id){
        // 调用service方法完成对id为2的这条记录的查询
        // 问题：findById方法中怎么才能获取restful编程风格中url里面占位符的值

        return "findById: "+ id ;
    }


    /*
        新增方法
     */
    @PostMapping("/user") // @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String post(){
        // 新增
        return "post";
    }

    /*
        更新方法
     */
    @PutMapping("/user")
    public String put(){
        // 更新操作
        return "put";
    }

    /*
        删除方法
     */
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Integer id){

        return "delete" + id;
    }





}
