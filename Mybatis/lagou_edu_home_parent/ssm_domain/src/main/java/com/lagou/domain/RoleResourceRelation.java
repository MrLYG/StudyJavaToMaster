package com.lagou.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Ken
 * @Date: 2021/5/16 17:58
 */
@Data
public class RoleResourceRelation {
    private Integer id;
    private Integer resourceId;
    private Integer roleId;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedby;


}
