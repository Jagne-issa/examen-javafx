package main.java.com.issa.repositories;

import com.issa.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientRepository {

    private SessionFactory sessionFactory;

    public ClientRepository() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
    }

    public Client findClientByPhoneNumber(String phoneNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Client client = session.get(Client.class, phoneNumber);
        session.getTransaction().commit();
        return client;
    }
}



// // package main.java.com.issa.repositories;

// // import com.issa.entities.Client;
// // import jakarta.persistence.EntityManager;
// // import jakarta.persistence.EntityTransaction;

// // import java.util.List;

// // public class ClientRepository {
// //     private final EntityManager entityManager;

// //     public ClientRepository(EntityManager entityManager) {
// //         this.entityManager = entityManager;
// //     }

// //     public void save(Client client) {
// //         EntityTransaction transaction = entityManager.getTransaction();
// //         transaction.begin();
// //         entityManager.persist(client);
// //         transaction.commit();
// //     }

// //     public Client findByTelephone(String telephone) {
// //         return entityManager.createQuery("SELECT c FROM Client c WHERE c.telephone = :telephone", Client.class)
// //                 .setParameter("telephone", telephone)
// //                 .getSingleResult();
// //     }

// //     public List<Client> findAll() {
// //         return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
// //     }
// // }
