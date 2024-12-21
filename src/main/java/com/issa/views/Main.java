package main.java.com.issa.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PageCommande.fxml"));
        AnchorPane root = loader.load();
        CommandeController controller = loader.getController();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());  // Appliquer le CSS
        primaryStage.setTitle("Gestion des Commandes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}













// package main.java.com.issa.views;

// import com.issa.entities.Article;
// import com.issa.entities.Client;
// import com.issa.entities.Commande;
// import com.issa.repositories.ArticleRepository;
// import com.issa.repositories.ClientRepository;
// import com.issa.repositories.CommandeRepository;
// import com.issa.services.ArticleService;
// import com.issa.services.ClientService;
// import com.issa.services.CommandeService;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.Persistence;

// public class Main {
//     public static void main(String[] args) {
//         EntityManagerFactory emf = Persistence.createEntityManagerFactory("examenPU");
//         EntityManager em = emf.createEntityManager();

//         // Initialisation des repositories
//         ArticleRepository articleRepository = new ArticleRepository(em);
//         ClientRepository clientRepository = new ClientRepository(em);
//         CommandeRepository commandeRepository = new CommandeRepository(em);

//         // Initialisation des services
//         ArticleService articleService = new ArticleService(articleRepository);
//         ClientService clientService = new ClientService(clientRepository);
//         CommandeService commandeService = new CommandeService(commandeRepository);

//         // Création et ajout d'un client
//         Client client = new Client();
//         client.setNom("Diop");
//         client.setPrenom("Amina");
//         client.setTelephone("771234567");
//         clientService.ajouterClient(client);

//         // Recherche d'un client
//         Client foundClient = clientService.rechercherParTelephone("771234567");
//         if (foundClient != null) {
//             System.out.println("Client trouvé : " + foundClient.getNom() + " " + foundClient.getPrenom());
//         }

//         // Création et ajout d'un article
//         Article article = new Article();
//         article.setNom("Cahier");
//         article.setPrix(1500);
//         article.setStock(20);
//         articleService.ajouterArticle(article);

//         // Création et ajout d'une commande
//         Commande commande = new Commande();
//         commande.setClient(foundClient);
//         commandeService.ajouterCommande(commande);

//         // Ajout d'un article à une commande
//         commandeService.ajouterArticleACommande(commande, article);

//         // Liste des commandes
//         commandeService.listerCommandes().forEach(c -> {
//             System.out.println("Commande ID : " + c.getId() + ", Client : " + c.getClient().getNom());
//         });

//         em.close();
//         emf.close();
//     }
// }
