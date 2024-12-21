package com.gestion.services;

import com.gestion.entity.Article;
import com.gestion.repository.ArticleRepository;

public class ArticleService {

    private ArticleRepository articleRepo;

    public ArticleService(ArticleRepository articleRepo) {
        this.articleRepo = articleRepo;
    }

    public void ajouterArticle(long articleId, String nom, double prix, int quantite) {
        Article article = new Article(articleId, nom, prix, quantite);
        articleRepo.save(article);
        System.out.println("Article ajouté avec succès.");
    }

    public void afficherArticles() {
        articleRepo.findAll().forEach((id, article) -> System.out.println(article));
    }
}