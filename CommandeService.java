package com.gestion.services;

import com.gestion.entity.Client;
import com.gestion.entity.Commande;
import com.gestion.repository.ClientRepository;
import com.gestion.repository.CommandeRepository;

public class CommandeService {

    private CommandeRepository commandeRepo;
    private ClientRepository clientRepo;

    public CommandeService(CommandeRepository commandeRepo, ClientRepository clientRepo) {
        this.commandeRepo = commandeRepo;
        this.clientRepo = clientRepo;
    }

    public void creerCommande(long commandeId, String telephoneClient) {
        Client client = clientRepo.findByTelephone(telephoneClient);
        if (client != null) {
            Commande commande = new Commande(commandeId, client);
            commandeRepo.save(commande);
            System.out.println("Commande créée avec succès.");
        } else {
            System.out.println("Client non trouvé. Commande non créée.");
        }
    }
}
