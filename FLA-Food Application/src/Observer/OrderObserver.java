package Observer;

import builder.Order;

public interface OrderObserver {
	void update(Order order);
}
