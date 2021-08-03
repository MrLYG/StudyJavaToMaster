package com.lagou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 课程章节表(CourseSection)实体类
 *
 * @author LaoSun
 * @since 2020-09-08 15:19:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseSection implements Serializable {

    private List<CourseLesson> courseLessons; // 一章对应多个小节

    private static final long serialVersionUID = -27927452337172294L;
    /**
    * id
    */
    private Object id;
    /**
    * 课程id
    */
    private Integer courseId;
    /**
    * 章节名
    */
    private String sectionName;
    /**
    * 章节描述
    */
    private String description;
    /**
    * 记录创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 是否删除
    */
    private Object isDe;
    /**
    * 排序字段
    */
    private Integer orderNum;
    /**
    * 状态，0:隐藏；1：待更新；2：已发布
    */
    private Integer status;



}