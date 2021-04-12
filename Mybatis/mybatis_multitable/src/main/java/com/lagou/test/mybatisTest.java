package com.lagou.test;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import com.lagou.mapper.OrderMapper;
import com.lagou.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {

    /*
        一对一关联查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
     */
    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Orders> orders = mapper.findAllWithUser();

        for (Orders order : orders) {
            System.out.println(order);
        }

        sqlSession.close();


    }


    /*
       一对多关联查询：查询所有用户及关联的订单信息
    */
    @Test
    public void test2() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithOrder = mapper.findAllWithOrder();

        for (User user : allWithOrder) {
            System.out.println(user);
        }

        sqlSession.close();


    }


    /*
     多对多关联查询：查询所有用户及关联的角色信息
  */
    @Test
    public void test3() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithRole = mapper.findAllWithRole();

        for (User user : allWithRole) {
            System.out.println(user);
        }

        sqlSession.close();


    }

    /*
        一对一嵌套查询：查询所有订单及关联的用户信息
    */
    @Test
    public void test4() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Orders> allWithUser2 = mapper.findAllWithUser2();

        for (Orders orders : allWithUser2) {
            System.out.println(orders);
        }

        sqlSession.close();


    }


    /*
       一对多嵌套查询：查询所有用户及关联的订单信息
   */
    @Test
    public void test5() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithOrder2 = mapper.findAllWithOrder2();

        for (User user : allWithOrder2) {
            System.out.println(user);

            // 要用到该用户的订单信息
            // System.out.println(user.getOrdersList());
        }

        sqlSession.close();


    }

    /*
    多对多嵌套查询：查询所有用户及关联的角色信息
*/
    @Test
    public void test6() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithRole2 = mapper.findAllWithRole2();

        for (User user : allWithRole2) {
            System.out.println(user);
        }

        sqlSession.close();

    }


    /*
        验证mybatis中的一级缓存
     */
    @Test
    public void testOneCache() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 根据id查询用户信息
        // 第一次查询，查询的数据库
        User user1 = userMapper.findById(1);
        System.out.println(user1);

        // clearCache: 手动清空缓存
        //sqlSession.clearCache();

        // 第二次查询，查询的是一级缓存
        User user2 = userMapper.findById(1);
        System.out.println(user2);

        sqlSession.close();

    }


    /*
       验证mybatis中的二级缓存
    */
    @Test
    public void testTwoCache() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);

        // 第一次查询
        User user = userMapper1.findById(1);

        System.out.println(user);

        // 只有执行sqlSession.commit或者sqlSession.close，那么一级缓存中内容才会刷新到二级缓存
        sqlSession1.close();


        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        User user2 = userMapper2.findById(1);

        System.out.println(user2);

        sqlSession2.close();



    }





}
