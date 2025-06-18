public class Main {
    public static void main(String[] args) {
        var order = new Order(12345);

        var priceObserver = new PriceObserver();
        var quantityObserver = new QuantityObserver();

        order.attach(priceObserver);
        order.attach(quantityObserver);

        System.out.println("=== Initial Order ===");
        System.out.println(order);

        // Case 1: Add items with total below discount and free shipping thresholds
        var item1 = new OrderItem("Laptop", 150, 1);
        var item2 = new OrderItem("Mouse", 20, 2);
        order.addItem(item1);
        order.addItem(item2);
        System.out.println("=== After Adding Items Below Thresholds ===");
        System.out.println(order);

        // Case 2: Add items to exceed discount threshold
        var item3 = new OrderItem("Monitor", 100, 1);
        order.addItem(item3);
        System.out.println("=== After Adding Items Exceeding Discount Threshold ===");
        System.out.println(order);

        // Case 3: Add items to exceed free shipping threshold
        var item4 = new OrderItem("Keyboard", 50, 3);
        order.addItem(item4);
        System.out.println("=== After Adding Items Exceeding Free Shipping Threshold ===");
        System.out.println(order);
    }
}