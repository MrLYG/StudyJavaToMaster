package com.lagou.service;

import com.lagou.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {

    /**
     * 查询所有资源分类
     */
    public List<ResourceCategory> findAllResourceCategory();

    /**
     * 添加资源分类
     *
     * @param resourceCategory
     */
    public void saveResourceCategory(ResourceCategory resourceCategory);

    /**
     * 修改资源分类
     *
     * @param resourceCategory
     */
    public void updateResourceCategory(ResourceCategory resourceCategory);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteResourceCategory(Integer id);

}
