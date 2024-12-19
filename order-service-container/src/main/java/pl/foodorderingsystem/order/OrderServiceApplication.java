package pl.foodorderingsystem.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "pl.foodorderingsystem.order"})
@EntityScan(basePackages = { "pl.foodorderingsystem.order"})
@SpringBootApplication(scanBasePackages = "pl.foodorderingsystem.order")
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
