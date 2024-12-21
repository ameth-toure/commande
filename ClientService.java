package com.gestion.services;

import java.util.HashMap;
import java.util.Map;

import com.gestion.entity.Client;
import com.gestion.repository.ClientRepository;

public class ClientService {
    private Map<Long, Client> clients = new HashMap<>();
    private ClientRepository clientRepo; 

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    
   public void ajouterClient(long id, String nom, String prenom, String telephone, String ville, String quartier, String adresse) {
    
    if (clientRepo.existsById(id)) {
        System.out.println("Erreur : L'ID du client doit être unique. ID déjà utilisé.");
        return;
    }
    
    
    Client client = new Client(id, nom, prenom, telephone, ville, quartier, adresse);
    clientRepo.save(client);
    System.out.println("Client ajouté avec succès : " + client);
}

    
    public void afficherClients() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client dans la base de données.");
        } else {
            clients.forEach((id, client) -> System.out.println(client));
        }
    }

    
    public Client trouverClientParTelephone(String telephone) {
        for (Client client : clients.values()) {
            if (client.getTelephone().equals(telephone)) {
                return client;
            }
        }
        return null;
    }
}
