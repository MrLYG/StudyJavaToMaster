package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.*;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;


    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourseVo resourseVo) {

        //分页查询
        PageHelper.startPage(resourseVo.getCurrentPage(),resourseVo.getPageSize());

        List<Resource> allResourceByPage = resourceMapper.findAllResourceByPage(resourseVo);

        PageInfo<Resource> pageInfo = new PageInfo<>(allResourceByPage);

        return pageInfo;
    }

    @Override
    public ResponseResult findResourceListByRoleId(Integer roleId) {
        List<ResourceCategory> categorys = resourceMapper.findAllCategoryByRoleId(roleId);
        for (ResourceCategory category : categorys) {
            List<Resource> list = resourceMapper.findResourceListByRoleId(roleId, category.getId());
            category.setResourceList(list);
        }
        Map map = new HashMap<>();
        map.put("content" ,categorys);
        System.out.println(categorys);
        return new ResponseResult(true,200,"获取当前角色拥有的资源信息成功",map);
    }
}
