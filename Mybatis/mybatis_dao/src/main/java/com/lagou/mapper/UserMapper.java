package com.lagou.mapper;

import com.lagou.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*
        根据id查询用户
     */

    public User findUserById(int id);

    /*
        查询所有用户
     */
    public List<User> findAllResultMap();

    /*
        多条件查询方式一
     */
    public List<User> findByIdAndUsername1(int id,String username);

    /*
       多条件查询方式二
    */
    public List<User> findByIdAndUsername2(@Param("id") int id, @Param("username") String username);


    /*
      多条件查询方式三
   */
    public List<User> findByIdAndUsername3(User user);


    /*
        模糊查询：方式一
     */
    public List<User> findByUsername(String username);


    /*
    模糊查询：方式二
    */
    public List<User> findByUsername2(String username);


    /*
     添加用户：获取返回主键：方式一
     */
    public void saveUser(User user);


    /*
    添加用户：获取返回主键：方式二
    */
    public void saveUser2(User user);



    /*
      动态sql的if标签：多条件查询
    */
    public List<User> findByIdAndUsernameIf(User user);


    /*
     动态sql的set标签：动态更新
   */
    public void updateIf(User user);


    /*
        动态sql的foreach标签：多值查询:集合
    */
    public List<User> findByList(List<Integer> ids);


    /*
       动态sql的foreach标签：多值查询：数组
   */
    public List<User> findByArray(Integer[] ids);





}
