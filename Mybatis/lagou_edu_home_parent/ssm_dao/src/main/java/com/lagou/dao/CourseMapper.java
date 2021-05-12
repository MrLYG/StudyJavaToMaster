package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.util.List;

/**
 * @Author: Ken
 * @Date: 2021/5/10 19:15
 */
public interface CourseMapper {
    /**
     * 多条件查询
     * @param courseVO
     * @return
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);
    /*
        新增课程信息
     */
    public void saveCourse(Course course);

    /*
        新增讲师信息
     */
    public void saveTeacher(Teacher teacher);

    /*
        更新课程信息
     */
    public void updateCourse(Course course);

    /*
        更新讲师信息
     */
    public void updateTeacher(Teacher teacher);

    /*
        回显课程信息（根据ID查询对应的课程信息及关联的讲师信息）
     */
    public CourseVO findCourseById(Integer id);

    /*
        课程状态管理
     */
    public void updateCourseStatus(Course course);

}
