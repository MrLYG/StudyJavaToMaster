package per.lyg.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import per.lyg.domain.Article;
import per.lyg.service.ArticleService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:applicationContext.xml"})
@ContextConfiguration("classpath:applicationContext.xml")
public class TestProject {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testFindAll() {
//        System.out.println("111111111111111111");
        List<Article> articles = articleService.findAll();
        System.out.println(articles);
    }

    @Test
    public void testAddArticle() {
        Article article = new Article();
        article.setTitle("lyg");
        article.setContent("lyg");
        String res = articleService.addArticle(article);
        System.out.println(res);
        testFindAll();
    }

    public void testAddArticle1() {
        Article article = new Article();
        article.setTitle("lyg");
        article.setContent("lyg");
        String res = articleService.addArticle(article);
        System.out.println(res);
        testFindAll();
    }
}
