package com.shoppingCart.ShoppingCart.security.repository;

import com.shoppingCart.ShoppingCart.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Get user by username
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username);
}