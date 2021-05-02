package per.lyg.dao;

import per.lyg.domain.Article;

import java.util.List;

/**
 * @author hp
 */
public interface ArticleDao {

    public List<Article> findAll();

    public int addArticle(Article article);
}
