package per.lyg.service;

import per.lyg.domain.Article;

import java.util.List;

public interface ArticleService {
    public List<Article> findAll();
    public String addArticle(Article article);
}
