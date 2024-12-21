package com.gestion;

import java.util.Scanner;

import com.gestion.repository.ArticleRepository;
import com.gestion.repository.ClientRepository;
import com.gestion.repository.CommandeArticleRepository;
import com.gestion.repository.CommandeRepository;
import com.gestion.services.ArticleService;
import com.gestion.services.ClientService;
import com.gestion.services.CommandeArticleService;
import com.gestion.services.CommandeService;

public class Main {

    public static void main(String[] args) {
        
        ClientRepository clientRepo = new ClientRepository();
        ArticleRepository articleRepo = new ArticleRepository();
        CommandeRepository commandeRepo = new CommandeRepository();
        CommandeArticleRepository commandeArticleRepo = new CommandeArticleRepository();

        
        ClientService clientService = new ClientService(clientRepo);
        ArticleService articleService = new ArticleService(articleRepo);
        CommandeService commandeService = new CommandeService(commandeRepo, clientRepo);
        CommandeArticleService commandeArticleService = new CommandeArticleService(commandeArticleRepo);

        Scanner scanner = new Scanner(System.in);
        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("=== Menu ===");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Ajouter un article");
            System.out.println("3. Créer une commande");
            System.out.println("4. Ajouter des articles à la commande");
            System.out.println("5. Modifier la quantité ou le prix d'un article dans une commande");
            System.out.println("6. Supprimer un article d'une commande");
            System.out.println("7. Afficher les clients");
            System.out.println("8. Afficher les articles");
            System.out.println("9. Quitter");
            System.out.print("Choisissez une option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  

            switch (option) {
                case 1: 
                    try {
                        System.out.print("ID du client: ");
                        long clientId = scanner.nextLong();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Nom: ");
                        String nom = scanner.nextLine();
                        System.out.print("Prénom: ");
                        String prenom = scanner.nextLine();
                        System.out.print("Numéro de téléphone: ");
                        String telephone = scanner.nextLine();
                        System.out.print("Ville: ");
                        String ville = scanner.nextLine();
                        System.out.print("Quartier: ");
                        String quartier = scanner.nextLine();
                        System.out.print("Adresse: ");
                        String adresse = scanner.nextLine();
                        clientService.ajouterClient(clientId, nom, prenom, telephone, ville, quartier, adresse);
                    } catch (Exception e) {
                        System.out.println("Erreur lors de l'ajout du client: " + e.getMessage());
                    }
                    break;

                case 2: 
                    try {
                        System.out.print("ID de l'article: ");
                        long articleId = scanner.nextLong();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Nom de l'article: ");
                        String articleNom = scanner.nextLine();
                        System.out.print("Prix: ");
                        double prix = scanner.nextDouble();
                        System.out.print("Quantité disponible: ");
                        int quantite = scanner.nextInt();
                        articleService.ajouterArticle(articleId, articleNom, prix, quantite);
                    } catch (Exception e) {
                        System.out.println("Erreur lors de l'ajout de l'article: " + e.getMessage());
                    }
                    break;

                case 3: 
                    try {
                        System.out.print("ID de la commande: ");
                        long commandeId = scanner.nextLong();
                        scanner.nextLine();  
                        System.out.print("Numéro de téléphone du client: ");
                        String telClient = scanner.nextLine();
                        commandeService.creerCommande(commandeId, telClient);
                    } catch (Exception e) {
                        System.out.println("Erreur lors de la création de la commande: " + e.getMessage());
                    }
                    break;

                case 4: 
                    try {
                        System.out.print("ID de la commande: ");
                        long commandeIdToAdd = scanner.nextLong();
                        System.out.print("ID de l'article à ajouter: ");
                        long articleIdToAdd = scanner.nextLong();
                        System.out.print("Quantité à ajouter: ");
                        int quantiteToAdd = scanner.nextInt();
                        commandeArticleService.ajouterArticleACommande(commandeIdToAdd, articleIdToAdd, quantiteToAdd);
                    } catch (Exception e) {
                        System.out.println("Erreur lors de l'ajout de l'article à la commande: " + e.getMessage());
                    }
                    break;

                case 5: 
                    try {
                        System.out.print("ID de la commande: ");
                        long commandeIdToModify = scanner.nextLong();
                        System.out.print("ID de l'article à modifier: ");
                        long articleIdToModify = scanner.nextLong();
                        System.out.print("Nouvelle quantité: ");
                        int newQuantite = scanner.nextInt();
                        System.out.print("Nouveau prix (0 si inchangé): ");
                        double newPrix = scanner.nextDouble();
                        commandeArticleService.modifierArticleDansCommande(commandeIdToModify, articleIdToModify, newQuantite, newPrix);
                    } catch (Exception e) {
                        System.out.println("Erreur lors de la modification de l'article dans la commande: " + e.getMessage());
                    }
                    break;

                case 6: 
                    try {
                        System.out.print("ID de la commande: ");
                        long commandeIdToDelete = scanner.nextLong();
                        System.out.print("ID de l'article à supprimer: ");
                        long articleIdToDelete = scanner.nextLong();
                        commandeArticleService.supprimerArticleDeCommande(commandeIdToDelete, articleIdToDelete);
                    } catch (Exception e) {
                        System.out.println("Erreur lors de la suppression de l'article de la commande: " + e.getMessage());
                    }
                    break;

                case 7: 
                    clientService.afficherClients();
                    break;

                case 8: 
                    articleService.afficherArticles();
                    break;

                case 9:
                    continueMenu = false;
                    System.out.println("Au revoir!");
                    break;

                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
