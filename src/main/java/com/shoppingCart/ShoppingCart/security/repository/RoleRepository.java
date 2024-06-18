package com.shoppingCart.ShoppingCart.security.repository;

import com.shoppingCart.ShoppingCart.security.models.Role;
import com.shoppingCart.ShoppingCart.security.models.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    /**
     * Get rol by RoleName enum
     * @param roleName
     * @return
     */
    Optional<Role> findByRoleName(RoleName roleName);
}
