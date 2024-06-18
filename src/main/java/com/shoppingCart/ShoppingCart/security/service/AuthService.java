package com.shoppingCart.ShoppingCart.security.service;

import com.shoppingCart.ShoppingCart.security.dto.AuthResponse;
import com.shoppingCart.ShoppingCart.security.dto.LoginRequest;
import com.shoppingCart.ShoppingCart.security.dto.UserRequest;
import com.shoppingCart.ShoppingCart.security.dto.UserResponse;
import com.shoppingCart.ShoppingCart.security.models.Role;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Set;

@Service
public interface AuthService {

    /**
     * authenticates user by credentails a return user details & token
     * @param loginRequest
     * @return
     */
    AuthResponse login(LoginRequest loginRequest);

    /**
     * ccreate a new user
     * @param user
     * @return
     */
    UserResponse register(UserRequest user);

    /**
     * map roles from string to RolName
     * @param roleList
     * @return
     */
    Set<Role> setRoles(Set<String> roleList);

    AuthResponse refreshToken(AuthResponse authResponse) throws ParseException;
}

