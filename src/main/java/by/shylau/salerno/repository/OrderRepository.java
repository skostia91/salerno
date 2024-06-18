package by.shylau.salerno.repository;

import by.shylau.salerno.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
