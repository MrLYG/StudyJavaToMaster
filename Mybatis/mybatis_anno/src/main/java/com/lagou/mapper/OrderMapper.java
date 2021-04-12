package com.lagou.mapper;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderMapper {


    /*
        查询所有订单，同时查询订单所属的用户信息
     */


    @Select("select * from orders")
    @Results({  // 代替的就是resultMap标签 id标签  result标签
          @Result(property = "id",column = "id",id = true),
          @Result(property = "ordertime",column = "ordertime"),
          @Result(property = "total",column = "total"),
          @Result(property = "uid",column = "uid"),
            @Result(property = "user",javaType = User.class,column = "uid",one = @One(select = "com.lagou.mapper.UserMapper.findById",fetchType = FetchType.EAGER))
    })
    public List<Orders> findAllWithUser();



    /*
        根据传递过来的用户id,查询该用户所具有的订单信息
     */
    @Select("select * from orders where uid = #{uid}")
    public List<Orders> findOrderByUid(Integer uid);




}
