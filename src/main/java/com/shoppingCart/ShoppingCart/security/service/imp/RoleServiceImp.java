package com.shoppingCart.ShoppingCart.security.service.imp;

import com.shoppingCart.ShoppingCart.security.models.Role;
import com.shoppingCart.ShoppingCart.security.models.RoleName;
import com.shoppingCart.ShoppingCart.security.repository.RoleRepository;
import com.shoppingCart.ShoppingCart.security.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleRepository repository;

    @Override
    public Role findRoleByName(RoleName roleName) {
        return repository.findByRoleName(roleName).orElse(null);
    }
    

}
