package com.gestion.entity;

public class Commande {
    private long id;
    private Client client;

    
    public Commande(long id, Client client) {
        this.id = id;
        this.client = client;
    }

  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{id=" + id + ", client=" + client + "}";
    }
}
