package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

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
}
