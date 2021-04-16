package per.lyg.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import per.lyg.domain.Article;
import per.lyg.mapper.ArticleMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {

    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        List<Article> articles = mapper.findAll();

        for (Article article : articles) {
            System.out.println(article);
        }

        sqlSession.close();


    }
}
