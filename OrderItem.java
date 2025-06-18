public class OrderItem {
    private final String name;
    private final double priceUsd;
    private final int quantity;

    public OrderItem(String name, double priceUsd, int quantity) {
        this.name = name;
        this.priceUsd = priceUsd;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public int getQuantity() {
        return quantity;
    }

    public double computeTotalPriceUsd() {
        return priceUsd * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f x %d = $%.2f", name, priceUsd, quantity, computeTotalPriceUsd());
    }
}
