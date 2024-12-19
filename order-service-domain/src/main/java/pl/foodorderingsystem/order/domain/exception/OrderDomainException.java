package pl.foodorderingsystem.order.domain.exception;

public class OrderDomainException extends RuntimeException {

    public OrderDomainException(String message) {
    }

    public OrderDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
