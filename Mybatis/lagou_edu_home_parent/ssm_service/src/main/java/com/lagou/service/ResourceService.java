package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourseVo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;

import java.util.List;

public interface ResourceService {

    /**
        资源分页&多条件查询
     */
    public PageInfo<Resource> findAllResourceByPage(ResourseVo resourseVo);

    /**
     * 获取当前角色拥有的 资源信息
     * @param roleId
     * @return
     */
    public ResponseResult findResourceListByRoleId(Integer roleId);
}
