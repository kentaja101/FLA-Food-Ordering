package singleton;

import Observer.OrderManager;

public class OrderManagerSingleton {
    private static OrderManager instance;

    private OrderManagerSingleton() {
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }
}