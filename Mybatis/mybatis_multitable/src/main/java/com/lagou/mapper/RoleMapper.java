package com.lagou.mapper;

import com.lagou.domain.Role;

import java.util.List;

public interface RoleMapper {

    /*
        根据用户id查询对应角色
     */
    public List<Role>  findByUid(Integer uid);



}
