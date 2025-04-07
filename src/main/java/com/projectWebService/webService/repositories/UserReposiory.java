package com.projectWebService.webService.repositories;
import com.projectWebService.webService.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposiory extends JpaRepository<User, Long> {




}
