package com.gestion.services;

import com.gestion.repository.CommandeArticleRepository;

public class CommandeArticleService {

    private CommandeArticleRepository commandeArticleRepo;

    public CommandeArticleService(CommandeArticleRepository commandeArticleRepo) {
        this.commandeArticleRepo = commandeArticleRepo;
    }

    public void ajouterArticleACommande(long commandeId, long articleId, int quantite) {
        commandeArticleRepo.addArticleToCommande(commandeId, articleId, quantite);
        System.out.println("Article ajouté à la commande.");
    }

    public void modifierArticleDansCommande(long commandeId, long articleId, int nouvelleQuantite, double nouveauPrix) {
        if (nouveauPrix > 0) {
            commandeArticleRepo.updatePrix(commandeId, articleId, nouveauPrix);
        }
        commandeArticleRepo.updateQuantite(commandeId, articleId, nouvelleQuantite);
        System.out.println("Article modifié dans la commande.");
    }

    public void supprimerArticleDeCommande(long commandeId, long articleId) {
        commandeArticleRepo.removeArticleFromCommande(commandeId, articleId);
        System.out.println("Article supprimé de la commande.");
    }
}
