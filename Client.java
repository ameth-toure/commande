


package com.gestion.entity;

public class Client {
    private long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String ville;
    private String quartier;
    private String adresse;

   
    public Client(long id, String nom, String prenom, String telephone, String ville, String quartier, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.ville = ville;
        this.quartier = quartier;
        this.adresse = adresse;
    }

   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Client{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "', telephone='" + telephone + "', ville='" + ville + "', quartier='" + quartier + "', adresse='" + adresse + "'}";
    }
}
