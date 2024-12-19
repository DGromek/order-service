package pl.foodorderingsystem.order.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.foodorderingsystem.order.domain.model.Order;
import pl.foodorderingsystem.order.adapter.persistence.jpa.JpaOrderRepository;
import pl.foodorderingsystem.order.adapter.persistence.jpa.entity.OrderEntity;
import pl.foodorderingsystem.order.out.OrderRepository;

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
