package pl.foodorderingsystem.order.infrastructure;

import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.foodorderingsystem.order.domain.domain.OrderDomainService;
import pl.foodorderingsystem.order.domain.domain.OrderDomainServiceImpl;
import pl.foodorderingsystem.order.domain.out.OrderRepository;

@Configuration
public class BeanConfig {

    @Bean
    public OrderDomainService orderDomainService(OrderRepository orderRepository, Validator validator) {
        return new OrderDomainServiceImpl(validator, orderRepository);
    }
}
