package Observer;

import java.util.ArrayList;
import java.util.List;

import builder.Order;

public class OrderManager implements OrderSubject {
    private List<OrderObserver> observers = new ArrayList<>();
    private Order currentOrder;

    @Override
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(currentOrder);
        }
    }

    public void placeOrder(Order order) {
        this.currentOrder = order;
        notifyObservers();
    }
}