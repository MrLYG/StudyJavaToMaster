package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.util.List;

public interface CourseService {

    /**
     * 查询课程信息
     * */
    List<Course> findAllCourse(CourseVO courseVO);

    //public PageInfo findAllCoursePage(CourseVO courseVO);


    /**
     * 保存课程营销信息
     * */
    public void saveCourseOrTeacher(CourseVO courseVO);

    /**
     * 根据id获取课程信息
     * */
    public CourseVO findCourseById(int id);

    /**
     * 修改课程营销信息
     * */
    public void updateCourseOrTeacher(CourseVO courseVO);

    /**
     * 修改课程状态
     * */
    public void updateCourseStatus(int id, int status);



}
