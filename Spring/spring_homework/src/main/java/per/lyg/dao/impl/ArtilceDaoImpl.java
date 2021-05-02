package per.lyg.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import per.lyg.dao.ArticleDao;
import per.lyg.domain.Article;
import per.lyg.test.TestProject;

import java.util.List;

@Repository
public class ArtilceDaoImpl implements ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Article> findAll() {
        System.out.println("findAllDao 执行了");

        String sql = "SELECT * FROM t_article";
        List<Article> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Article>(Article.class));
        return list;

    }

    @Override
    public int addArticle(Article article) {
        String sql = "INSERT INTO t_article (title,content) VALUES(?,?)";
        int i = jdbcTemplate.update(sql, article.getTitle(), article.getContent());
        TestProject testProject = new TestProject();
        testProject.testFindAll();
        return i;
    }


}
