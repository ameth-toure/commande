package com.gestion.repository;

import java.util.HashMap;
import java.util.Map;

import com.gestion.entity.Article;

public class ArticleRepository {
    private Map<Long, Article> articleStorage = new HashMap<>();

    
    public Article findById(Long id) {
        return articleStorage.get(id);
    }

    
    public void save(Article article) {
        articleStorage.put(article.getId(), article); 
    }

    
    public void delete(Long id) {
        articleStorage.remove(id);
    }

    
    public Map<Long, Article> findAll() {
        return articleStorage;
    }
}
