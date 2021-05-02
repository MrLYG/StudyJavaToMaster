package per.lyg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.lyg.dao.ArticleDao;
import per.lyg.domain.Article;
import per.lyg.service.ArticleService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public List<Article> findAll() {
        System.out.println("findAllService 执行了");
        List<Article> articles = articleDao.findAll();
        return articles;
    }

    @Override
    public String addArticle(Article article) {
        int i = articleDao.addArticle(article);
        return i>0 ? article+"--添加成功" :"添加失败";
    }
}
