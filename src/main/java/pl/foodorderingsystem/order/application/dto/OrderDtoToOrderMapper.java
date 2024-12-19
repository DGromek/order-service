package pl.foodorderingsystem.order.application.dto;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.foodorderingsystem.order.domain.domain.Order;

@Mapper
public interface OrderDtoToOrderMapper {

    @Mapping(target = "orderItems.unitPrice", ignore = true)
    Order map(OrderDto orderDto);
}
