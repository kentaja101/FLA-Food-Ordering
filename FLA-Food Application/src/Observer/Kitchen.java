package Observer;

import builder.Order;

public class Kitchen implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Kitchen received order: " + order);
    }
}