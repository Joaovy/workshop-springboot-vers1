package com.projectWebService.webService.repositories;

import com.projectWebService.webService.entities.Category;
import com.projectWebService.webService.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
