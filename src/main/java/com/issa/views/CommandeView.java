package main.java.com.issa.views;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.issa.entities.Client;
import com.issa.entities.Article;
import com.issa.services.ClientService;
import com.issa.services.ArticleService;
import com.issa.services.CommandeService;

public class CommandeView {

    private ClientService clientService = new ClientService();
    private ArticleService articleService = new ArticleService();
    private CommandeService commandeService = new CommandeService();

    public void showCommandeScreen(Stage primaryStage) {
        TextField phoneField = new TextField();
        phoneField.setPromptText("Enter Client Phone Number");

        Button searchButton = new Button("Search Client");
        TextField nameField = new TextField();
        nameField.setPromptText("Client Name");
        nameField.setDisable(true);
        
        // Other UI components like TableView for articles, quantity, and price
        
        searchButton.setOnAction(e -> {
            String phone = phoneField.getText();
            Client client = clientService.getClientByPhoneNumber(phone);
            if (client != null) {
                nameField.setText(client.getFullName());
                // Other fields for address, etc.
            } else {
                // Disable order section if client not found
            }
        });

        // Layout setup
        VBox layout = new VBox(10);
        layout.getChildren().addAll(phoneField, searchButton, nameField);
        
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Commande");
        primaryStage.show();
    }
}
