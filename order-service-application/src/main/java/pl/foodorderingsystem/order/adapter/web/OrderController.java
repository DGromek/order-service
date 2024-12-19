package pl.foodorderingsystem.order.adapter.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.foodorderingsystem.order.domain.model.Order;
import pl.foodorderingsystem.order.in.OrderDomainService;
import pl.foodorderingsystem.order.adapter.web.dto.OrderDto;
import pl.foodorderingsystem.order.adapter.web.dto.OrderDtoToOrderMapper;

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
