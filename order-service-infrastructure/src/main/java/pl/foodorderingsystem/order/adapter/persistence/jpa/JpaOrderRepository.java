package pl.foodorderingsystem.order.adapter.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.foodorderingsystem.order.adapter.persistence.jpa.entity.OrderEntity;

@Repository
public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {
}
