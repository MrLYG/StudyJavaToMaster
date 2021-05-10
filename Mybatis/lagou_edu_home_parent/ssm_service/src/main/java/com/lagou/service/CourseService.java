package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.util.List;

/**
 * @Author: Ken
 * @Date: 2021/5/10 19:22
 */
public interface CourseService {

    public List<Course> findCourseByCondition(CourseVO courseVO);
}
