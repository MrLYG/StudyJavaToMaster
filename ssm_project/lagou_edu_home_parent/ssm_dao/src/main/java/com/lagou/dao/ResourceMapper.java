package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourseVo;
import com.lagou.domain.Role;

import java.util.List;

public interface ResourceMapper {


    /**
        资源分页&多条件查询
     */
    public List<Resource> findAllResourceByPage(ResourseVo resourseVo);

    /**
     * 获取当前角色拥有的 资源信息
     * @param roleId
     * @return
     */
    public List<Resource> findResourceListByRoleId(Integer roleId,Integer categoryId);

    /**
     * 查询当前角色拥有的资源分类信息
     * @param roleId
     * @return
     */
    public List<ResourceCategory> findAllCategoryByRoleId(Integer roleId);




}
