package pl.foodorderingsystem.order.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Address {
    @NotEmpty
    private final String street;
    @NotEmpty
    private final String buildingNumber;
    private final String apartmentNumber;
    @NotEmpty
    @Pattern(regexp = "\\d{2}-\\d{3}")
    private final String postalCode;
    @NotEmpty
    private final String city;
}
