package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAllCourse(CourseVO courseVO) {

        List<Course> list = courseMapper.findAllCourse(courseVO);
        return list;
    }

//    @Override
//    public PageInfo findAllCoursePage(CourseVO courseVO) {
//
//        PageHelper.startPage(courseVO.getCurrentPage(),courseVO.getPageSize());
//        List<Course> courseList = courseMapper.findAllCourse(courseVO);
//
//        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
//        return pageInfo;
//    }




    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) {

        try {
            //封装课程信息
            Course course = new Course();
            BeanUtils.copyProperties(course,courseVO);

            //补全信息
            Date date = new Date();
            course.setCreateTime(date);
            course.setUpdateTime(date);

            //保存课程
            courseMapper.saveCourse(course);

            //获取新插入数据的id
            int id = course.getId();

            //封装讲师信息
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacher,courseVO);

            //补全信息
            teacher.setCourseId(id);
            teacher.setCreateTime(date);
            teacher.setUpdateTime(date);

            //保存讲师信息
            courseMapper.saveTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CourseVO findCourseById(int id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) {
        try {
            //封装课程信息
            Course course = new Course();
            BeanUtils.copyProperties(course,courseVO);

            //补全信息
            Date date = new Date();
            course.setUpdateTime(date);

            //保存课程
            courseMapper.updateCourse(course);

            //封装讲师信息
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacher,courseVO);

            //补全信息
            teacher.setCourseId(course.getId());
            teacher.setUpdateTime(date);

            //保存讲师信息
            courseMapper.updateTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourseStatus(int id,int status) {

        try {
            //封装数据
            Course course = new Course();
            course.setStatus(status);
            course.setId(id);
            course.setUpdateTime(new Date());

            //调用Dao
            courseMapper.updateCourseStatus(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
