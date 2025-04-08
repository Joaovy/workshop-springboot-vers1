package com.projectWebService.webService.repositories;

import com.projectWebService.webService.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
