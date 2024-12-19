package pl.foodorderingsystem.order.adapter;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pl.foodorderingsystem.order.domain.model.Order;
import pl.foodorderingsystem.order.adapter.persistence.jpa.entity.OrderEntity;

@Mapper
public interface OrderToOrderEntityMapper {

    OrderEntity toEntity(Order order);

    Order toDomain(OrderEntity order);


    @AfterMapping
    default void afterToEntityMapping(@MappingTarget OrderEntity orderEntity) {
        orderEntity.getAddress().setOrder(orderEntity);
        orderEntity.getOrderItems().forEach(orderItemEntity -> orderItemEntity.setOrder(orderEntity));
    }
}
