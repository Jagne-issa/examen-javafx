package main.java.com.issa.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.com.issa.entities.Client;
import main.java.com.issa.services.ClientService;

import java.util.Optional;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class CommandeController {

    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField addressField;
    @FXML
    private ComboBox<String> articleComboBox;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;
    @FXML
    private TableView<OrderItem> orderTable;
    @FXML
    private TableColumn<OrderItem, String> articleColumn;
    @FXML
    private TableColumn<OrderItem, Double> priceColumn;
    @FXML
    private TableColumn<OrderItem, Integer> quantityColumn;
    @FXML
    private TableColumn<OrderItem, Double> totalColumn;
    @FXML
    private TableColumn<OrderItem, String> actionsColumn;
    @FXML
    private Button addItemButton;
    @FXML
    private Button saveOrderButton;
    @FXML
    private Button cancelOrderButton;
    @FXML
    private Text statusText;

    private ObservableList<OrderItem> orderItems = FXCollections.observableArrayList();
    private ClientService clientService = new ClientService();
    private OrderService orderService = new OrderService();

    @FXML
    public void initialize() {
        articleComboBox.setItems(FXCollections.observableArrayList("Article 1", "Article 2", "Article 3"));

        articleColumn.setCellValueFactory(cellData -> cellData.getValue().articleProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        totalColumn.setCellValueFactory(cellData -> cellData.getValue().totalPriceProperty().asObject());
        actionsColumn.setCellValueFactory(cellData -> cellData.getValue().actionsProperty());
    }

    @FXML
    public void searchClient(ActionEvent event) {
        String phoneNumber = phoneNumberField.getText();

        Client client = clientService.findClientByPhone(phoneNumber);
        if (client != null) {
            fullNameField.setText(client.getFullName());
            addressField.setText(client.getAddress());
            statusText.setText("Client trouvé : " + client.getFullName());
            enableOrderSection(true);
        } else {
            fullNameField.setText("");
            addressField.setText("");
            statusText.setText("Client non trouvé.");
            enableOrderSection(false);
        }
    }

    private void enableOrderSection(boolean enable) {
        articleComboBox.setDisable(!enable);
        priceField.setDisable(!enable);
        quantityField.setDisable(!enable);
        addItemButton.setDisable(!enable);
        saveOrderButton.setDisable(!enable);
    }

    @FXML
    private void handleAddItemButtonAction() {
        // Ajouter l'article à la table
        String article = articleComboBox.getSelectionModel().getSelectedItem();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        double totalItemPrice = price * quantity;

        // Mettre à jour la table des articles
        ObservableList<OrderItem> items = orderTable.getItems();
        items.add(new OrderItem(article, price, quantity, totalItemPrice));

        // Calculer le total de la commande
        double totalOrder = items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        totalField.setText(String.format("%.2f", totalOrder)); // Afficher le total
    }

    @FXML
    public void addItemToOrder(ActionEvent event) {
        String article = articleComboBox.getValue();
        if (article == null || priceField.getText().isEmpty() || quantityField.getText().isEmpty()) {
            showAlert("Erreur", "Tous les champs doivent être remplis.");
            return;
        }

        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        OrderItem orderItem = new OrderItem(article, price, quantity);
        orderItems.add(orderItem);
        orderTable.setItems(orderItems);
    }

    @FXML
    public void saveOrder(ActionEvent event) {
        if (orderItems.isEmpty()) {
            showAlert("Erreur", "Veuillez ajouter des articles à la commande.");
            return;
        }

        Client client = clientService.findClientByPhone(phoneNumberField.getText());
        Order order = new Order(client, orderItems);

        orderService.saveOrder(order);
        showAlert("Succès", "Commande enregistrée avec succès !");
        resetForm();
    }

    @FXML
    public void cancelOrder(ActionEvent event) {
        resetForm();
    }

    private void resetForm() {
        phoneNumberField.clear();
        fullNameField.clear();
        addressField.clear();
        articleComboBox.getSelectionModel().clearSelection();
        priceField.clear();
        quantityField.clear();
        orderItems.clear();
        orderTable.setItems(orderItems);
        statusText.setText("");
        enableOrderSection(false);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
