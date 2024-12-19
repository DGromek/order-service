package pl.foodorderingsystem.order.domain;

import java.util.Arrays;

public enum OrderStatusTransition {

    //Correct processing
    ORDER_VALIDATION(OrderStatus.NEW, OrderStatus.VALIDATED),
    PAY(OrderStatus.VALIDATED, OrderStatus.PAID),
    ACCEPT(OrderStatus.PAID, OrderStatus.ACCEPTED),
    FINISH(OrderStatus.ACCEPTED, OrderStatus.FINISHED),
    //Error handling
    INVALID_ORDER(OrderStatus.NEW, OrderStatus.CANCELLING),
    PAYMENT_FAILED(OrderStatus.VALIDATED, OrderStatus.CANCELLING),
    ORDER_REJECTED(OrderStatus.PAID, OrderStatus.CANCELLING),
    FINISH_CANCELLATION(OrderStatus.CANCELLING, OrderStatus.CANCELED);

    private final OrderStatus previous;
    private final OrderStatus next;

    private final static OrderStatusTransition[] values = OrderStatusTransition.values();

    OrderStatusTransition(OrderStatus previous, OrderStatus next) {
        this.previous = previous;
        this.next = next;
    }

    public static void validateTransition(OrderStatus from, OrderStatus to) {
        boolean isTransactionValid = Arrays.stream(values)
                .anyMatch(orderStatusTransition ->
                        orderStatusTransition.previous == from &&
                                orderStatusTransition.next == to);
        if (!isTransactionValid) {
            throw new OrderDomainException("Transition from " + from + " status to " + to + " is not allowed!");
        }
    }
}
