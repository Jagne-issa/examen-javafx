package controller;

import entities.OrderItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class OrderController {

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

    private ObservableList<OrderItem> orderItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        
        articleColumn.setCellValueFactory(cellData -> cellData.getValue().articleProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        totalColumn.setCellValueFactory(cellData -> cellData.getValue().totalProperty().asObject());

        addItemButton.setOnAction(event -> addItem());
    }

    public void addItem() {
        String article = articleComboBox.getValue();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        OrderItem newItem = new OrderItem(article, price, quantity);
        orderItems.add(newItem);

        orderTable.setItems(orderItems);
    }
}
