package com.gestion.repository;

import java.util.HashMap;
import java.util.Map;

import com.gestion.entity.Client;

public class ClientRepository {
    private Map<Long, Client> clientStorage = new HashMap<>();

   
    public Client findByTelephone(String telephone) {
        for (Client client : clientStorage.values()) {
            if (client.getTelephone().equals(telephone)) {
                return client;
            }
        }
        return null; 
    }

    
    public void save(Client client) {
        clientStorage.put(client.getId(), client); 
    }

    
    public void delete(Long id) {
        clientStorage.remove(id);
    }

    
    public Map<Long, Client> findAll() {
        return clientStorage;
    }


    public boolean existsById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }
}
