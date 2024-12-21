package com.gestion.entity;

public class Article {
    private Long id;
    private String nom;
    private Double prix;
    private Integer quantiteDisponible;

    public Article(Long id, String nom, Double prix, Integer quantiteDisponible) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantiteDisponible = quantiteDisponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id <= 0) throw new IllegalArgumentException("ID doit être supérieur à 0");
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        if (prix <= 0) throw new IllegalArgumentException("Prix doit être supérieur à 0");
        this.prix = prix;
    }

    public Integer getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(Integer quantiteDisponible) {
        if(quantiteDisponible < 0) throw new IllegalArgumentException("Quantité disponible ne peut pas être négative");
        this.quantiteDisponible = quantiteDisponible;
    }

    @Override
    public String toString() {
        return "Article{id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantiteDisponible=" + quantiteDisponible + '}';
    }
}