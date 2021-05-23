package com.lagou.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author: Ken
 * @Date: 2021/5/16 18:20
 */
@Data
public class RoleContextResourceVO {
    private Integer roleId;
    private List<Integer> resourceIdList;
}
