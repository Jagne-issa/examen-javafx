package main.java.com.issa.entities;

import com.issa.entities.Article;
import com.issa.entities.Client;
import com.issa.entities.Commande;
import com.issa.services.CommandeService;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PageCommande extends Application {

    private CommandeService commandeService;
    private TextField clientPhoneField;
    private Label clientInfoLabel;
    private TableView<Article> articleTableView;
    private ObservableList<Article> commandeArticles;
    private TextField prixField, quantiteField;
    private Button ajouterArticleBtn, supprimerArticleBtn, validerCommandeBtn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialisation du service
        commandeService = new CommandeService();

        // Création de l'interface utilisateur
        clientPhoneField = new TextField();
        clientPhoneField.setPromptText("Numéro de téléphone du client");
        clientInfoLabel = new Label("Client non trouvé.");
        Button searchClientBtn = new Button("Rechercher Client");

        searchClientBtn.setOnAction(e -> rechercherClient());

        // Table des articles
        articleTableView = new TableView<>();
        articleTableView.setEditable(true);

        // Colonnes de la table des articles
        TableColumn<Article, String> articleColumn = new TableColumn<>("Article");
        articleColumn.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());

        TableColumn<Article, Integer> quantiteColumn = new TableColumn<>("Quantité");
        quantiteColumn.setCellValueFactory(cellData -> cellData.getValue().quantiteProperty().asObject());

        TableColumn<Article, Double> prixColumn = new TableColumn<>("Prix");
        prixColumn.setCellValueFactory(cellData -> cellData.getValue().prixProperty().asObject());

        articleTableView.getColumns().addAll(articleColumn, quantiteColumn, prixColumn);

        // Ajout d'un article à la commande
        prixField = new TextField();
        prixField.setPromptText("Prix");
        quantiteField = new TextField();
        quantiteField.setPromptText("Quantité");

        ajouterArticleBtn = new Button("Ajouter un article");
        ajouterArticleBtn.setOnAction(e -> ajouterArticle());

        supprimerArticleBtn = new Button("Supprimer un article");
        supprimerArticleBtn.setOnAction(e -> supprimerArticle());

        // Validation de la commande
        validerCommandeBtn = new Button("Valider la commande");
        validerCommandeBtn.setOnAction(e -> validerCommande());

        // Mise en page
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(clientPhoneField, searchClientBtn, clientInfoLabel, articleTableView,
                prixField, quantiteField, ajouterArticleBtn, supprimerArticleBtn, validerCommandeBtn);

        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setTitle("Gestion de Commande");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Recherche du client par téléphone
    private void rechercherClient() {
        String phone = clientPhoneField.getText();
        Client client = commandeService.getClientByPhone(phone);
        if (client != null) {
            clientInfoLabel.setText("Nom: " + client.getNom() + ", Adresse: " + client.getAdresse());
            commandeArticles = FXCollections.observableArrayList();
            articleTableView.setItems(commandeArticles);
        } else {
            clientInfoLabel.setText("Client non trouvé.");
            commandeArticles = FXCollections.observableArrayList();
            articleTableView.setItems(commandeArticles);
        }
    }

    // Ajouter un article à la commande
    private void ajouterArticle() {
        String prixText = prixField.getText();
        String quantiteText = quantiteField.getText();

        if (!prixText.isEmpty() && !quantiteText.isEmpty()) {
            double prix = Double.parseDouble(prixText);
            int quantite = Integer.parseInt(quantiteText);

            // Créer un article (vous devriez remplacer par un appel à une méthode qui récupère les articles depuis la BD)
            Article article = new Article("Article Example", prix, quantite);
            commandeArticles.add(article);

            prixField.clear();
            quantiteField.clear();
        }
    }

    // Supprimer un article de la commande
    private void supprimerArticle() {
        Article selectedArticle = articleTableView.getSelectionModel().getSelectedItem();
        if (selectedArticle != null) {
            commandeArticles.remove(selectedArticle);
        }
    }

    // Valider la commande
    private void validerCommande() {
        // Créer la commande et l'enregistrer dans la base de données
        Commande commande = new Commande();
        commande.setArticles(commandeArticles);
        commandeService.saveCommande(commande);

        // Afficher un message de confirmation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Commande Validée");
        alert.setHeaderText("Commande enregistrée avec succès !");
        alert.showAndWait();
    }
}
