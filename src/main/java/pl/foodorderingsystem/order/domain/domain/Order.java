package pl.foodorderingsystem.order.domain.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Order {
    @NotNull
    private final UUID customerId;
    @NotNull
    private final UUID restaurantId;
    @Valid
    @NotNull
    private final Address address;
    @Valid
    @Size(min = 1)
    private final List<OrderItem> orderItems;

    private UUID orderId;
    private OrderStatus orderStatus;
    private LocalDateTime createdDateTime;

    public Order(UUID customerId, UUID restaurantId, Address address, List<OrderItem> orderItems) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.address = address;
        this.orderItems = orderItems;
    }

    public void initialize() {
        if (orderId != null) {
            throw new OrderDomainException("Order already initialized!");
        }
        orderId = UUID.randomUUID();
        orderStatus = OrderStatus.NEW;
        createdDateTime = LocalDateTime.now();
    }
}
