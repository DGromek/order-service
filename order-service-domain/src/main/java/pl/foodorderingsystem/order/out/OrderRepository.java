package pl.foodorderingsystem.order.out;


import pl.foodorderingsystem.order.domain.Order;

public interface OrderRepository {

    Order saveOrder(Order orderToSave);
}
