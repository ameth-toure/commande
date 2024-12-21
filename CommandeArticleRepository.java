package com.gestion.repository;

import java.util.HashMap;
import java.util.Map;

public class CommandeArticleRepository {
    // Stocke les articles de la commande avec leur quantité et prix
    private Map<Long, Map<Long, ArticleQuantitePrix>> commandeArticleStorage = new HashMap<>();

    // Classe interne pour gérer la quantité et le prix d'un article dans une commande
    private static class ArticleQuantitePrix {
        Integer quantite;
        Double prix;

        public ArticleQuantitePrix(Integer quantite, Double prix) {
            this.quantite = quantite;
            this.prix = prix;
        }

        public void setQuantite(Integer quantite) {
            this.quantite = quantite;
        }

        public void setPrix(Double prix) {
            this.prix = prix;
        }

        @SuppressWarnings("unused")
        public Integer getQuantite() {
            return quantite;
        }

        @SuppressWarnings("unused")
        public Double getPrix() {
            return prix;
        }
    }

    // Ajouter un article à une commande avec sa quantité et son prix
    public void addArticleToCommande(Long commandeId, Long articleId, Integer quantite, Double prix) {
        commandeArticleStorage
            .computeIfAbsent(commandeId, k -> new HashMap<>())
            .put(articleId, new ArticleQuantitePrix(quantite, prix));
    }

    // Mettre à jour la quantité d'un article dans une commande
    public void updateQuantite(Long commandeId, Long articleId, Integer nouvelleQuantite) {
        Map<Long, ArticleQuantitePrix> articles = commandeArticleStorage.get(commandeId);
        if (articles != null && articles.containsKey(articleId)) {
            articles.get(articleId).setQuantite(nouvelleQuantite);
        }
    }

    // Supprimer un article d'une commande
    public void removeArticleFromCommande(Long commandeId, Long articleId) {
        Map<Long, ArticleQuantitePrix> articles = commandeArticleStorage.get(commandeId);
        if (articles != null) {
            articles.remove(articleId);
        }
    }

    // Récupérer les articles d'une commande
    public Map<Long, ArticleQuantitePrix> getArticlesFromCommande(Long commandeId) {
        return commandeArticleStorage.getOrDefault(commandeId, new HashMap<>());
    }

    // Mettre à jour le prix d'un article dans une commande
    public void updatePrix(Long commandeId, Long articleId, Double nouveauPrix) {
        Map<Long, ArticleQuantitePrix> articles = commandeArticleStorage.get(commandeId);
        if (articles != null && articles.containsKey(articleId)) {
            articles.get(articleId).setPrix(nouveauPrix);
        }
    }

    public void addArticleToCommande(long commandeId, long articleId, int quantite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addArticleToCommande'");
    }
}