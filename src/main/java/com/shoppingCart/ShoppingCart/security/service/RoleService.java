package com.shoppingCart.ShoppingCart.security.service;

import com.shoppingCart.ShoppingCart.security.models.Role;
import com.shoppingCart.ShoppingCart.security.models.RoleName;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    /**
     * Get role by name
     * @param roleName
     * @return
     */
    Role findRoleByName(RoleName roleName);
}
