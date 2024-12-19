package pl.foodorderingsystem.order.domain.out;


import pl.foodorderingsystem.order.domain.domain.Order;

public interface OrderRepository {

    Order saveOrder (Order orderToSave);
}
