package pl.foodorderingsystem.order;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pl.foodorderingsystem.order.domain.Order;
import pl.foodorderingsystem.order.jpa.OrderEntity;

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
