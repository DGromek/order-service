package pl.foodorderingsystem.order.domain;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import pl.foodorderingsystem.order.out.OrderRepository;

public class OrderDomainServiceImpl implements OrderDomainService {

    private final Validator validator;
    private final OrderRepository orderRepository;

    public OrderDomainServiceImpl(Validator validator, OrderRepository orderRepository) {
        this.validator = validator;
        this.orderRepository = orderRepository;
    }

    public OrderDomainServiceImpl(OrderRepository orderRepository) {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory();) {
            validator = factory.getValidator();
        }
        this.orderRepository = orderRepository;
    }

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
