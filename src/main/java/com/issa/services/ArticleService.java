package main.java.com.issa.services;

import com.issa.entities.Article;
import com.issa.repositories.ArticleRepository;

public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService() {
        this.articleRepository = new ArticleRepository();
    }

    public Article getArticleByCode(String code) {
        return articleRepository.findArticleByCode(code);
    }
}













// package main.java.com.issa.services;

// import com.issa.entities.Article;
// import com.issa.repositories.ArticleRepository;

// import java.util.List;

// public class ArticleService {
//     private final ArticleRepository articleRepository;

//     public ArticleService(ArticleRepository articleRepository) {
//         this.articleRepository = articleRepository;
//     }

//     public void ajouterArticle(Article article) {
//         articleRepository.save(article);
//     }

//     public List<Article> listerArticles() {
//         return articleRepository.findAll();
//     }
// }
