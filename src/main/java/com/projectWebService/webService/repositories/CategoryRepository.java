package com.projectWebService.webService.repositories;

import com.projectWebService.webService.entities.Category;
import com.projectWebService.webService.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
