package pl.foodorderingsystem.order.adapter.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto implements Serializable {
    @NotNull
    private final UUID customerId;
    @NotNull
    private final UUID restaurantId;
    @Valid
    private final AddressDto address;
    @Valid
    @Size(min = 1)
    private final List<OrderItemDto> orderItems;
}
