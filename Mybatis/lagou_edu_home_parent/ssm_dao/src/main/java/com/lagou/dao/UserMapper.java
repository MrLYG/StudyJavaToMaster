package com.lagou.dao;

import com.lagou.domain.User;
import com.lagou.domain.UserVo;

import java.util.List;

public interface UserMapper {

    /*
        用户分页&多条件组合查询
     */
    public List<User> findAllUserByPage(UserVo userVo);
}
