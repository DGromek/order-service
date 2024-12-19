package pl.foodorderingsystem.order.in;

import pl.foodorderingsystem.order.domain.model.Order;

public interface OrderDomainService {
    Order createOrder(Order orderToSave);

    Order pay(Order order);

    Order startCancellation(Order order);
}
