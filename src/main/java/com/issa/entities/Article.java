package main.java.com.issa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    private String code;
    private String name;
    private double price;
    private int quantity;

    // Getters and Setters
}





// package main.java.com.issa.entities;

// import jakarta.persistence.*;

// @Entity
// public class Article {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String nom;
//     private double prix;
//     private int stock;

//     // Getters et Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getNom() {
//         return nom;
//     }

//     public void setNom(String nom) {
//         this.nom = nom;
//     }

//     public double getPrix() {
//         return prix;
//     }

//     public void setPrix(double prix) {
//         this.prix = prix;
//     }

//     public int getStock() {
//         return stock;
//     }

//     public void setStock(int stock) {
//         this.stock = stock;
//     }
// }
