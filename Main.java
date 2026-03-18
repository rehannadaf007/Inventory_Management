import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StockManager manager = new StockManager();
        Scanner scanner = new Scanner(System.in);
        

        manager.addProduct(new Product("P001", "Laptop", 1200.00, 5));
        manager.addProduct(new Product("P002", "Mouse", 25.00, 50));
        manager.addProduct(new Product("P004", "Monitor", 300.00, 10));
        manager.addProduct(new Product("P005", "Headphones", 80.00, 20));   
        manager.addProduct(new Product("P006", "Webcam", 60.00, 15)); 
        manager.addProduct(new Product("P007", "Keyboard", 100.00, 25)); 
        manager.addProduct(new Product("P008", "USB Cable", 10.00, 100)); 
        manager.addProduct(new Product("P009", "External Hard Drive", 120.00, 12)); 
        manager.addProduct(new Product("P010", "Printer", 200.00, 8));  
        manager.addProduct(new Product("P011", "Scanner", 150.00, 6));  
        manager.addProduct(new Product("P012", "Tablet", 300.00, 7));   
        manager.addProduct(new Product("P013", "Smartphone", 800.00, 10));       

        
        boolean running = true;
        while (running) {
            System.out.println("\n--- Inventory Management System Menu ---");
            System.out.println("1. List all products");
            System.out.println("2. Display individual product info");
            System.out.println("3. Purchase (add stock)");
            System.out.println("4. Shipping (sell stock)");
            System.out.println("5. Balance stock");
            System.out.println("6. Calculate loss and profit");
            System.out.println("7. Purchase report");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                        manager.listAllProducts();
                        break;
                    case 2:
                        System.out.print("Enter Product ID: ");
                        String id = scanner.nextLine();
                        manager.displayProductInfo(id);
                        break;
                    case 3:
                        System.out.print("Enter Product ID: ");
                        String purchaseId = scanner.nextLine();
                        System.out.print("Enter quantity to purchase: ");
                        int purchaseQty = scanner.nextInt();
                        System.out.print("Enter unit cost: ");
                        double unitCost = scanner.nextDouble();
                        manager.purchase(purchaseId, purchaseQty, unitCost);
                        break;
                    case 4:
                        System.out.print("Enter Product ID: ");
                        String shipId = scanner.nextLine();
                        System.out.print("Enter quantity to ship: ");
                        int shipQty = scanner.nextInt();
                        manager.shipping(shipId, shipQty);
                        break;
                    case 5:
                        System.out.print("Enter Product ID: ");
                        String balanceId = scanner.nextLine();
                        System.out.print("Enter new stock quantity: ");
                        int newQty = scanner.nextInt();
                        manager.balanceStock(balanceId, newQty);
                        break;
                    case 6:
                        manager.calculateLossAndProfit();
                        break;
                    case 7:
                        manager.purchaseReport();
                        break;
                    case 8:
                        running = false;
                        System.out.println("Exiting system. Goodbye! 👋");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number for your choice.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}