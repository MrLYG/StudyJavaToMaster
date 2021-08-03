package com.lagou.course;

import com.lagou.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: lagou-edu
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-08 16:45
 * @Description:
 */
public interface CourseService {
    /**
     * 查询全部课程信息
     * @return
     */
    List<Course> getAllCourse();
    /**
     * 查询已登录用户购买的全部课程信息
     * @return
     */
    List<Course> getCourseByUserId(String userId);
    /**
     * 查询某门课程的详细信息
     * @param courseid 课程编号
     * @return
     */
    Course getCourseById(Integer courseid);
}
