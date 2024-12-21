package com.gestion.repository;

import java.util.HashMap;
import java.util.Map;

import com.gestion.entity.Commande;

public class CommandeRepository {
    private Map<Long, Commande> commandeStorage = new HashMap<>();

    
    public Commande findById(Long id) {
        return commandeStorage.get(id);
    }

    
    public void save(Commande commande) {
        commandeStorage.put(commande.getId(), commande); 
    }

    
    public void delete(Long id) {
        commandeStorage.remove(id);
    }

    
    public Map<Long, Commande> findAll() {
        return commandeStorage;
    }
}