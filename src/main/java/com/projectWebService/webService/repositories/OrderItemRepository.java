package com.projectWebService.webService.repositories;

import com.projectWebService.webService.entities.Order;
import com.projectWebService.webService.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
