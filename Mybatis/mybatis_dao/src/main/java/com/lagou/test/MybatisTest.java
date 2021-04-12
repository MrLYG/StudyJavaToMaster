package com.lagou.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.domain.User;
import com.lagou.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {


    /*
        mybatis的Dao层mapper代理方式测试
     */
    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);

    }


    @Test
    public void test2() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allResultMap = mapper.findAllResultMap();
        for (User user : allResultMap) {
            System.out.println(user);
        }
        sqlSession.close();


    }



    /*
        多条件查询：方式一
     */
    @Test
    public void test3() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findByIdAndUsername1(1, "子慕");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();


    }


    /*
        多条件查询：方式二
     */
    @Test
    public void test4() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findByIdAndUsername2(1, "子慕");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();


    }

    /*
      多条件查询：方式三
   */
    @Test
    public void test5() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = new User();
        user1.setId(1);
        //user1.setUsernameabc("子慕");

        List<User> users = mapper.findByIdAndUsername3(user1);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }


    /*
        模糊查询：方式一
    */
    @Test
    public void test6() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findByUsername("%子慕%");
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.commit();
        sqlSession.close();

    }



    /*
    模糊查询：方式二
*/
    @Test
    public void test7() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findByUsername2("%子慕%");
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();

    }



    /*
        添加用户：返回主键方式一
     */
    @Test
    public void test8() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("某冰冰");
        user.setBirthday(new Date());
        user.setAddress("北京昌平");
        user.setSex("女");

        System.out.println(user);
        mapper.saveUser(user);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();

    }


    /*
       添加用户：返回主键方式一
    */
    @Test
    public void test9() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("汤唯");
        user.setBirthday(new Date());
        user.setAddress("北京昌平");
        user.setSex("女");

        System.out.println(user);
        mapper.saveUser2(user);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();

    }



    /*
     动态sql之if： 多条件查询
  */
    @Test
    public void test10() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(11);
        user.setUsername("汤唯");

        List<User> users = mapper.findByIdAndUsernameIf(user);
        for (User user1 : users) {
            System.out.println(user1);
        }

        sqlSession.close();

    }


    /*
        动态sql之set： 动态更新
    */
    @Test
    public void test11() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(1);
        user.setUsername("子慕最帅");
        user.setAddress("北京海淀区拉勾网");

        mapper.updateIf(user);

        sqlSession.commit();

        sqlSession.close();

    }


    /*
     动态sql之foreach： 多值查询
 */
    @Test
    public void test12() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(6);
        ids.add(2);

        List<User> users = mapper.findByList(ids);
        for (User user : users) {
            System.out.println(user);
        }


        sqlSession.close();

    }


    /*
   动态sql之foreach： 多值查询 ：数组
*/
    @Test
    public void test13() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Integer[] ids = {2,6,9};

        List<User> byArray = mapper.findByArray(ids);
        for (User user : byArray) {
            System.out.println(user);
        }


        sqlSession.close();

    }


    /*
        核心配置文件深入：plugin标签：pageHelper
     */
    @Test
    public void test15() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 当前返回的 其实是基于UserMapper所产生的代理对象：底层：JDK动态代理 实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 设置分页参数
        // 参数1： 当前页
        // 参数2： 每页显示的条数
        PageHelper.startPage(1,2);

        List<User> users = mapper.findAllResultMap();
        for (User user : users) {
            System.out.println(user);
        }

        // 获取分页相关的其他参数
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println("总条数"+ pageInfo.getTotal());
        System.out.println("总页数"+ pageInfo.getPages());
        System.out.println("是否是第一页"+ pageInfo.isIsFirstPage());


        sqlSession.close();

    }






}
