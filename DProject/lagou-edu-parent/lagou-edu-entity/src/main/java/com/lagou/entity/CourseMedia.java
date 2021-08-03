package com.lagou.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 课节视频表(CourseMedia)实体类
 *
 * @author LaoSun
 * @since 2020-09-08 15:25:12
 */
public class CourseMedia implements Serializable {
    private static final long serialVersionUID = -80134795424357484L;
    /**
    * 课程媒体主键ID
    */
    private Integer id;
    /**
    * 课程Id
    */
    private Integer courseId;
    /**
    * 章ID
    */
    private Integer sectionId;
    /**
    * 课时ID
    */
    private Integer lessonId;
    /**
    * 封面图URL
    */
    private String coverImageUrl;
    /**
    * 时长（06:02）
    */
    private String duration;
    /**
    * 媒体资源文件对应的EDK
    */
    private String fileEdk;
    /**
    * 文件大小MB
    */
    private Object fileSize;
    /**
    * 文件名称
    */
    private String fileName;
    /**
    * 媒体资源文件对应的DK
    */
    private String fileDk;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 是否删除，0未删除，1删除
    */
    private Object isDel;
    /**
    * 时长，秒数（主要用于音频在H5控件中使用）
    */
    private Integer durationNum;
    /**
    * 媒体资源文件ID
    */
    private String fileId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFileEdk() {
        return fileEdk;
    }

    public void setFileEdk(String fileEdk) {
        this.fileEdk = fileEdk;
    }

    public Object getFileSize() {
        return fileSize;
    }

    public void setFileSize(Object fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDk() {
        return fileDk;
    }

    public void setFileDk(String fileDk) {
        this.fileDk = fileDk;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Object getIsDel() {
        return isDel;
    }

    public void setIsDel(Object isDel) {
        this.isDel = isDel;
    }

    public Integer getDurationNum() {
        return durationNum;
    }

    public void setDurationNum(Integer durationNum) {
        this.durationNum = durationNum;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

}