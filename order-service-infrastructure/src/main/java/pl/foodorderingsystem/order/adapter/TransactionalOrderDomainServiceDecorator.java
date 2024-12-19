package pl.foodorderingsystem.order.adapter;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.foodorderingsystem.order.domain.model.Order;
import pl.foodorderingsystem.order.in.OrderDomainService;

@Service
@Primary
@Data
public class TransactionalOrderDomainServiceDecorator implements OrderDomainService {

    private final OrderDomainService orderDomainService;

    @Transactional
    @Override
    public Order createOrder(Order orderToSave) {
        return orderDomainService.createOrder(orderToSave);
    }

    @Transactional
    @Override
    public Order pay(Order order) {
        return orderDomainService.pay(order);
    }

    @Transactional
    @Override
    public Order startCancellation(Order order) {
        return orderDomainService.startCancellation(order);
    }
}
