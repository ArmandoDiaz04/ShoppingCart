package com.shoppingCart.ShoppingCart.security.repositoy;

import com.shoppingCart.ShoppingCart.security.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String name);
}
