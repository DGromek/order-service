package pl.foodorderingsystem.order.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.foodorderingsystem.order.domain.domain.Order;
import pl.foodorderingsystem.order.domain.out.OrderRepository;
import pl.foodorderingsystem.order.infrastructure.jpa.JpaOrderRepository;
import pl.foodorderingsystem.order.infrastructure.jpa.OrderEntity;

@RequiredArgsConstructor
@Service
public class OrderRepositoryImpl implements OrderRepository {
    private final JpaOrderRepository jpaOrderRepository;
    private final OrderToOrderEntityMapper orderToOrderEntityMapper;

    @Override
    public Order saveOrder(Order orderToSave) {
        OrderEntity orderEntity = orderToOrderEntityMapper.toEntity(orderToSave);
        OrderEntity orderEntitySaved = jpaOrderRepository.save(orderEntity);
        return orderToOrderEntityMapper.toDomain(orderEntitySaved);
    }

}
