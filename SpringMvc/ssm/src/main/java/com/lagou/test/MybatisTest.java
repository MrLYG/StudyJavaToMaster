package com.lagou.test;

import com.lagou.dao.AccountDao;
import com.lagou.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void  testMybatis() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        AccountDao mapper = sqlSession.getMapper(AccountDao.class);

        List<Account> all = mapper.findAll();

        for (Account account : all) {
            System.out.println(account);
        }

        sqlSession.close();


    }




}
