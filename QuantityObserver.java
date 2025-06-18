public class QuantityObserver implements OrderObserver {
    private static final double FREE_SHIPPING_MIN_ORDER_ITEM_COUNT = 5;

    @Override
    public void update(Order order) {
        var orderItemCount = order.getItemCount();

        if (orderItemCount > FREE_SHIPPING_MIN_ORDER_ITEM_COUNT) {
            order.setShippingCost(0);
        } else {
            order.resetShippingCost();
        }
    }
}
