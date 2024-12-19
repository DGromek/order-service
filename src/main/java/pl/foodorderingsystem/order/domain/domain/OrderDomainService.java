package pl.foodorderingsystem.order.domain.domain;

public interface OrderDomainService {
    Order createOrder(Order orderToSave);

    Order pay(Order order);

    Order startCancellation(Order order);
}
