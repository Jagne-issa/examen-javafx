package main.java.com.issa.repositories;

import com.issa.entities.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ArticleRepository {

    private SessionFactory sessionFactory;

    public ArticleRepository() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Article.class).buildSessionFactory();
    }

    public Article findArticleByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Article article = session.get(Article.class, code);
        session.getTransaction().commit();
        return article;
    }
}










// package main.java.com.issa.repositories;

// import com.issa.entities.Article;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityTransaction;

// import java.util.List;

// public class ArticleRepository {
//     private final EntityManager entityManager;

//     public ArticleRepository(EntityManager entityManager) {
//         this.entityManager = entityManager;
//     }

//     public void save(Article article) {
//         EntityTransaction transaction = entityManager.getTransaction();
//         transaction.begin();
//         entityManager.persist(article);
//         transaction.commit();
//     }

//     public List<Article> findAll() {
//         return entityManager.createQuery("SELECT a FROM Article a", Article.class).getResultList();
//     }
// }
