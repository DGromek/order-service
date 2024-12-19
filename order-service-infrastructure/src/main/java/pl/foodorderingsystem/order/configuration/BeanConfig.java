package pl.foodorderingsystem.order.configuration;

import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.foodorderingsystem.order.in.OrderDomainService;
import pl.foodorderingsystem.order.in.OrderDomainServiceImpl;
import pl.foodorderingsystem.order.out.OrderRepository;

@Configuration
public class BeanConfig {

    @Bean
    public OrderDomainService orderDomainService(OrderRepository orderRepository, Validator validator) {
        return new OrderDomainServiceImpl(validator, orderRepository);
    }
}
