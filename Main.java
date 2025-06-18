public class Main {
    public static void main(String[] args) {
        var order = new Order(12345);

        var priceObserver = new PriceObserver();
        var quantityObserver = new QuantityObserver();

        order.attach(priceObserver);
        order.attach(quantityObserver);

        var mouse = new OrderItem("Mouse", 20, 4);

        order.addItem(new OrderItem("Thinkpad T14 2018", 200, 1));
        order.addItem(mouse);

        System.out.println(order);
    }
}
