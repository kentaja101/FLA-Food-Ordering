package builder;

public class Order {
    private String itemName;
    private int quantity;
    private double totalPrice;

    public static class OrderBuilder {
        private Order order = new Order();

        public OrderBuilder withItemName(String itemName) {
            order.itemName = itemName;
            return this;
        }

        public OrderBuilder withQuantity(int quantity) {
            order.quantity = quantity;
            return this;
        }

        public OrderBuilder withTotalPrice(double totalPrice) {
            order.totalPrice = totalPrice;
            return this;
        }

        public Order build() {
            return order;
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
