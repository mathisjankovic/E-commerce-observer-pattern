public class PriceObserver implements OrderObserver {
    private static final double DISCOUNT_VALUE_USD = 20;
    private static final double DISCOUNT_MIN_ORDER_VALUE_USD = 200;

    @Override
    public void update(Order order) {
        var orderTotalValueUsd = order.getTotalItemValueUsd();

        if (orderTotalValueUsd > DISCOUNT_MIN_ORDER_VALUE_USD) {
            order.setDiscount(DISCOUNT_VALUE_USD);
        } else {
            order.setDiscount(0);
        }
    }
}
