import java.util.ArrayList;

public class Order {
    private static final double SHIPPING_COST = 10;

    private final int id;
    private final ArrayList<OrderItem> items;

    private double totalItemValueUsd;
    private double discount;
    private double shippingCost;

    private ArrayList<OrderObserver> observers;

    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();

        this.totalItemValueUsd = 0;
        this.discount = 0;
        this.shippingCost = SHIPPING_COST;

        this.observers = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
        totalItemValueUsd += item.computeTotalPriceUsd();

        notifyObservers();
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
        totalItemValueUsd -= item.computeTotalPriceUsd();

        notifyObservers();
    }

    public double getTotalItemValueUsd() {
        return totalItemValueUsd;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void resetShippingCost() {
        shippingCost = SHIPPING_COST;
    }

    public double computeFinalPriceUsd() {
        var totalPrice = totalItemValueUsd - discount + shippingCost;
        return Math.max(totalPrice, 0);
    }

    public int getItemCount() {
        var itemCount = 0;

        for (OrderItem item : items) {
            itemCount += item.getQuantity();
        }
        return itemCount;
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        final String currencyDisplayFormat = "%.2f";

        var sb = new StringBuilder();

        sb.append("Order ID: ").append(id).append("\n");

        sb.append("Items:\n");
        for (OrderItem item : items) {
            sb.append("  ").append(item).append("\n");
        }

        sb.append("\nItem Total Value $").append(totalItemValueUsd).append("\n");

        var formattedDiscount = String.format(currencyDisplayFormat, this.discount);
        sb.append("Discount: $").append(formattedDiscount).append("\n");

        var formattedShippingCost = String.format(currencyDisplayFormat, this.shippingCost);
        sb.append("Shipping Cost: $").append(formattedShippingCost).append("\n");

        var formattedFinalTotal = String.format(currencyDisplayFormat, computeFinalPriceUsd());
        sb.append("Final Total: $").append(formattedFinalTotal).append("\n");

        return sb.toString();
    }
}
