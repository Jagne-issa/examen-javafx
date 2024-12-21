package main.java.com.issa.repositories;

import com.issa.entities.Commande;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CommandeRepository {

    private SessionFactory sessionFactory;

    public CommandeRepository() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Commande.class).buildSessionFactory();
    }

    // Méthode pour sauvegarder une commande
    public void saveCommande(Commande commande) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(commande);
        session.getTransaction().commit();
    }

    // Méthode pour récupérer une commande par son identifiant
    public Commande getCommandeById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Commande commande = session.get(Commande.class, id);
        session.getTransaction().commit();
        return commande;
    }

    // Méthode pour récupérer toutes les commandes
    public List<Commande> getAllCommandes() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Commande> commandes = session.createQuery("from Commande", Commande.class).getResultList();
        session.getTransaction().commit();
        return commandes;
    }

    // Méthode pour supprimer une commande
    public void deleteCommande(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Commande commande = session.get(Commande.class, id);
        if (commande != null) {
            session.delete(commande);
        }
        session.getTransaction().commit();
    }
}











// package main.java.com.issa.repositories;

// import com.issa.entities.Commande;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityTransaction;

// import java.util.List;

// public class CommandeRepository {
//     private final EntityManager entityManager;

//     public CommandeRepository(EntityManager entityManager) {
//         this.entityManager = entityManager;
//     }

//     public void save(Commande commande) {
//         EntityTransaction transaction = entityManager.getTransaction();
//         transaction.begin();
//         entityManager.persist(commande);
//         transaction.commit();
//     }

//     public List<Commande> findAll() {
//         return entityManager.createQuery("SELECT c FROM Commande c", Commande.class).getResultList();
//     }

//     public Commande findById(Long id) {
//         return entityManager.find(Commande.class, id);
//     }
// }
