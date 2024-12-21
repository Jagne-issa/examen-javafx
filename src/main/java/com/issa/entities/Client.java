package main.java.com.issa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    private String phoneNumber;
    private String fullName;
    private String address;
    private String city;
    private String district;
    private String houseNumber;

    // Getters and Setters
}










// package main.java.com.issa.entities;

// import jakarta.persistence.*;

// @Entity
// public class Client {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String nom;
//     private String prenom;
//     private String telephone;

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

//     public String getPrenom() {
//         return prenom;
//     }

//     public void setPrenom(String prenom) {
//         this.prenom = prenom;
//     }

//     public String getTelephone() {
//         return telephone;
//     }

//     public void setTelephone(String telephone) {
//         this.telephone = telephone;
//     }
// }
