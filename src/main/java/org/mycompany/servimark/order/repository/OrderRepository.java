package org.mycompany.servimark.order.repository;

import org.mycompany.servimark.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
