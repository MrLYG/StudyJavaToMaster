package com.lagou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {


    /*
        单文件上传
     */
    @RequestMapping("/fileupload")
    public String fileUpload(String username, MultipartFile filePic) throws IOException {

        //获取表单的提交参数，完成文件上传
        System.out.println(username);

        // 获取原始的文件上传名 a.txt  abc
        String originalFilename = filePic.getOriginalFilename();
        filePic.transferTo(new File("D:/upload/"+originalFilename));

        return "success";
    }


    /*
      多文件上传
   */
    @RequestMapping("/filesupload")
    public String filesUpload(String username, MultipartFile[] filePic) throws IOException {

        //获取表单的提交参数，完成文件上传
        System.out.println(username);

        // 获取原始的文件上传名 a.txt  abc
        for (MultipartFile multipartFile : filePic) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:/upload/"+originalFilename));

        }

        return "success";
    }








}
