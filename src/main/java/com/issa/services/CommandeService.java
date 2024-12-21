package main.java.com.issa.services;

import com.issa.entities.Client;
import com.issa.entities.Commande;
import com.issa.repositories.ClientRepository;
import com.issa.repositories.CommandeRepository;

public class CommandeService {

    private ClientRepository clientRepository;
    private CommandeRepository commandeRepository;

    public CommandeService() {
        clientRepository = new ClientRepository();
        commandeRepository = new CommandeRepository();
    }

    // Recherche du client par téléphone
    public Client getClientByPhone(String phone) {
        return clientRepository.getClientByPhone(phone);
    }

    // Sauvegarde de la commande
    public void saveCommande(Commande commande) {
        commandeRepository.saveCommande(commande);
    }
}









// package main.java.com.issa.services;

// import com.issa.entities.Client;
// import com.issa.entities.Commande;
// import com.issa.repositories.ClientRepository;
// import com.issa.repositories.CommandeRepository;

// public class CommandeService {

//     private ClientRepository clientRepository;
//     private CommandeRepository commandeRepository;

//     public CommandeService() {
//         clientRepository = new ClientRepository();
//         commandeRepository = new CommandeRepository();
//     }

//     // Recherche du client par téléphone
//     public Client getClientByPhone(String phone) {
//         return clientRepository.getClientByPhone(phone);
//     }

//     // Sauvegarde de la commande
//     public void saveCommande(Commande commande) {
//         commandeRepository.saveCommande(commande);
//     }
// }






// package main.java.com.issa.services;

// import com.issa.entities.Commande;
// import com.issa.entities.Article;

// import java.util.List;

// public class CommandeService {

//     public double calculateTotalAmount(List<Article> articles) {
//         double total = 0;
//         for (Article article : articles) {
//             total += article.getPrice() * article.getQuantity();
//         }
//         return total;
//     }
// }















// package main.java.com.issa.services;

// import com.issa.entities.Article;
// import com.issa.entities.Commande;
// import com.issa.repositories.CommandeRepository;

// import java.util.List;

// public class CommandeService {
//     private final CommandeRepository commandeRepository;

//     public CommandeService(CommandeRepository commandeRepository) {
//         this.commandeRepository = commandeRepository;
//     }

//     public void ajouterCommande(Commande commande) {
//         commandeRepository.save(commande);
//     }

//     public List<Commande> listerCommandes() {
//         return commandeRepository.findAll();
//     }

//     public void ajouterArticleACommande(Commande commande, Article article) {
//         commande.getArticles().add(article);
//         commandeRepository.save(commande);
//     }
// }
