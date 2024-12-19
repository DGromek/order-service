package pl.foodorderingsystem.order;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.foodorderingsystem.order.domain.Order;
import pl.foodorderingsystem.order.domain.OrderDomainService;
import pl.foodorderingsystem.order.dto.OrderDto;
import pl.foodorderingsystem.order.dto.OrderDtoToOrderMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderDomainService orderDomainService;
    private final OrderDtoToOrderMapper orderDtoToOrderMapper;

    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody @Valid OrderDto orderDto) {
        Order orderToCreate = orderDtoToOrderMapper.map(orderDto);
        Order savedOrder = orderDomainService.createOrder(orderToCreate);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
