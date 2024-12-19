package pl.foodorderingsystem.order.infrastructure;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import pl.foodorderingsystem.order.domain.domain.Address;
import pl.foodorderingsystem.order.domain.domain.Order;
import pl.foodorderingsystem.order.domain.domain.OrderItem;
import pl.foodorderingsystem.order.infrastructure.jpa.AddressEntity;
import pl.foodorderingsystem.order.infrastructure.jpa.OrderEntity;
import pl.foodorderingsystem.order.infrastructure.jpa.OrderItemEntity;

import java.util.List;

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
