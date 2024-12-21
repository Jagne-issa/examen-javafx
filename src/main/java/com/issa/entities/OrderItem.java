package main.java.com.issa.entities;

public class OrderItem {
    private String article;
    private double price;
    private int quantity;
    private double total;

    // Constructeur
    public OrderItem(String article, double price, int quantity) {
        this.article = article;
        this.price = price;
        this.quantity = quantity;
        this.total = price * quantity;
    }

    // Getters et setters
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        updateTotal();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateTotal();
    }

    public double getTotal() {
        return total;
    }

    // Méthode pour mettre à jour le total en fonction du prix et de la quantité
    private void updateTotal() {
        this.total = this.price * this.quantity;
    }

    // Redéfinir toString si vous souhaitez afficher l'objet facilement
    @Override
    public String toString() {
        return "OrderItem [article=" + article + ", price=" + price + ", quantity=" + quantity + ", total=" + total + "]";
    }
}
