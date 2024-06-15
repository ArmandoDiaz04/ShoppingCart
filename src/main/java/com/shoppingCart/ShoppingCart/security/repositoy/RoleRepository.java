package com.shoppingCart.ShoppingCart.security.repositoy;

import com.shoppingCart.ShoppingCart.security.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
