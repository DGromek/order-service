package pl.foodorderingsystem.order.adapter.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class OrderItemDto implements Serializable {
    @NotNull
    private final UUID productId;
    @Min(1)
    private final int quantity;
}
