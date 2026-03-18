public class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantityInStock;

    public Product(String productId, String productName, double price, int quantityInStock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }


    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantityInStock() { return quantityInStock; }


    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Price: $" + String.format("%.2f", price) +
               ", Stock: " + quantityInStock;
    }
}