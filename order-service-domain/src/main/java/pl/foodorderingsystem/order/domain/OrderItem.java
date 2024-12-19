package pl.foodorderingsystem.order.domain;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderItem {
    @NotNull
    private final UUID productId;
    @Min(1)
    private final int quantity;
    @DecimalMin(value = "0", inclusive = false)
    private BigDecimal unitPrice;
}
