import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private Map<String, Product> inventory = new HashMap<>();
    private double totalRevenue = 0.0;
    private double totalExpenses = 0.0;


    public void listAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in the inventory.");
            return;
        }
        
        System.out.println("--- Current Inventory ---");
        System.out.println("┌────────────┬────────────────────┬──────────┬────────────┐");
        System.out.println("│ ID         │ Name               │ Price    │ Stock      │");
        System.out.println("├────────────┼────────────────────┼──────────┼────────────┤");
        
        for (Product product : inventory.values()) {
            System.out.format("│ %-10s │ %-18s │ %8.2f │ %10d │%n", 
                              product.getProductId(),
                              product.getProductName(),
                              product.getPrice(),
                              product.getQuantityInStock());
        }
        
        System.out.println("└────────────┴────────────────────┴──────────┴────────────┘");
    }

    public void displayProductInfo(String productId) {
        Product product = inventory.get(productId);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product with ID '" + productId + "' not found.");
        }
    }


    public void purchase(String productId, int quantity, double unitCost) {
        Product product = inventory.get(productId);
        if (product != null) {
            int newQuantity = product.getQuantityInStock() + quantity;
            product.setQuantityInStock(newQuantity);
            System.out.println(quantity + " units of " + product.getProductName() + " purchased. New stock: " + newQuantity);
            totalExpenses += quantity * unitCost;
        } else {
            System.out.println("Product not found. Cannot purchase.");
        }
    }

    public void shipping(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            if (product.getQuantityInStock() >= quantity) {
                int newQuantity = product.getQuantityInStock() - quantity;
                product.setQuantityInStock(newQuantity);
                System.out.println(quantity + " units of " + product.getProductName() + " shipped. Remaining stock: " + newQuantity);
                totalRevenue += quantity * product.getPrice();
            } else {
                System.out.println("Not enough stock for " + product.getProductName() + ". Available: " + product.getQuantityInStock());
            }
        } else {
            System.out.println("Product not found. Cannot ship.");
        }
    }

    public void balanceStock(String productId, int newQuantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            int oldQuantity = product.getQuantityInStock();
            product.setQuantityInStock(newQuantity);
            System.out.println("Stock for " + product.getProductName() + " updated from " + oldQuantity + " to " + newQuantity + ".");
        } else {
            System.out.println("Product not found. Cannot balance stock.");
        }
    }

    public void calculateLossAndProfit() {
        double profit = totalRevenue - totalExpenses;
        System.out.println("--- Financial Summary ---");
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
        System.out.println("Total Expenses: $" + String.format("%.2f", totalExpenses));
        System.out.println("Net Profit/Loss: $" + String.format("%.2f", profit));
    }
 
    public void purchaseReport() {
        System.out.println("--- Simplified Purchase Report ---");
        System.out.println("Total value of all purchases to date: $" + String.format("%.2f", totalExpenses));
    }
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Added " + product.getProductName() + " to inventory.");
    }
}