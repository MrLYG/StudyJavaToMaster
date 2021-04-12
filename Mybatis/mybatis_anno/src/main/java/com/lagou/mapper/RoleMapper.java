package com.lagou.mapper;

import com.lagou.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {


    /*
        根据传递过来的用户id,查询该用户所具有的角色信息
     */
    @Select("SELECT * FROM sys_role r INNER JOIN sys_user_role ur ON ur.roleid = r.id WHERE ur.userid = #{uid}")
    public List<Role> findAllByUid(Integer uid);


}
