package pl.foodorderingsystem.order.in;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.RequiredArgsConstructor;
import pl.foodorderingsystem.order.domain.model.Order;
import pl.foodorderingsystem.order.out.OrderRepository;

@RequiredArgsConstructor
public class OrderDomainServiceImpl implements OrderDomainService {

    private final Validator validator;
    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Order orderToSave) {
        validateOrder(orderToSave);
        orderToSave.initialize();
        return orderRepository.saveOrder(orderToSave);
    }

    private void validateOrder(Order orderToSave) {
        var violations = validator.validate(orderToSave);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    public Order pay(Order order) {
        return null;
    }

    @Override
    public Order startCancellation(Order order) {
        return null;
    }
}
