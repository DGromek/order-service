package pl.foodorderingsystem.order.adapter.web.dto;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.foodorderingsystem.order.domain.model.Order;

@Mapper
public interface OrderDtoToOrderMapper {

    @Mapping(target = "orderItems.unitPrice", ignore = true)
    Order map(OrderDto orderDto);
}
