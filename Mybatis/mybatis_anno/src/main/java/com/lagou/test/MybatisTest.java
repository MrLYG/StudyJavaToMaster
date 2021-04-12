package com.lagou.test;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import com.lagou.mapper.OrderMapper;
import com.lagou.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {


    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;


    // 在 @Test方法标注的方法执行之前来执行
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

         sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

         sqlSession = sqlSessionFactory.openSession();
    }


    @After
    public void after(){

        sqlSession.commit();
        sqlSession.close();

    }



    /*
        测试查询方法
     */
    @Test
    public void testSelect() throws IOException {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> all = mapper.findAll();

        for (User user : all) {
            System.out.println(user);
        }

    }


    /*
        测试添加方法
     */
    @Test
    public void testInsert(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("汤唯");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("北京");

        mapper.save(user);

    }


    @Test
    public void testUpdate(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("柳岩真美");
        user.setBirthday(new Date());
        user.setId(9);

        mapper.update(user);

    }


    @Test
    public void testDelete(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.delete(9);

    }


    /*
        一对一查询（注解方式）
     */
    @Test
    public void testOneToOne(){

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Orders> allWithUser = mapper.findAllWithUser();

        for (Orders orders : allWithUser) {
            System.out.println(orders);
        }


    }


    /*
       一对多查询（注解方式）
    */
    @Test
    public void testOneToMany(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithOrder = mapper.findAllWithOrder();

        for (User user : allWithOrder) {
            System.out.println(user);
            System.out.println(user.getOrdersList());
        }


    }


    /*
   多对多查询（注解方式）
*/
    @Test
    public void testManyToMany(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithRole = mapper.findAllWithRole();

        for (User user : allWithRole) {
            System.out.println(user);
            System.out.println(user.getRoleList());
        }

    }


    /*
        测试注解实现二级缓存
     */
    @Test
    public void cacheTest(){

        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();


        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);


        User user1 = userMapper1.findById(1);

        System.out.println(user1);

        // 才能将内容从一级缓存刷新到二级缓存
        sqlSession1.close();

        User user2 = userMapper2.findById(1);

        System.out.println(user2);

        sqlSession2.close();



    }










}
