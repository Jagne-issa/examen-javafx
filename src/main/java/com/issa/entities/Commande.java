package main.java.com.issa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Client client;

    @OneToMany
    private List<Article> articles;
    
    private double totalAmount;

    // Getters and Setters
}







// package main.java.com.issa.entities;

// import jakarta.persistence.*;
// import java.util.List;

// @Entity
// public class Commande {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Client client;

//     @OneToMany
//     private List<Article> articles;

//     // Getters et Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Client getClient() {
//         return client;
//     }

//     public void setClient(Client client) {
//         this.client = client;
//     }

//     public List<Article> getArticles() {
//         return articles;
//     }

//     public void setArticles(List<Article> articles) {
//         this.articles = articles;
//     }
// }
