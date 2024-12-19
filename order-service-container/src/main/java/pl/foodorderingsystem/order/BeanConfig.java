package pl.foodorderingsystem.order;

import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.foodorderingsystem.order.domain.OrderDomainService;
import pl.foodorderingsystem.order.domain.OrderDomainServiceImpl;
import pl.foodorderingsystem.order.out.OrderRepository;

@Configuration
public class BeanConfig {

    @Bean
    public OrderDomainService orderDomainService(OrderRepository orderRepository, Validator validator) {
        return new OrderDomainServiceImpl(validator, orderRepository);
    }
}
