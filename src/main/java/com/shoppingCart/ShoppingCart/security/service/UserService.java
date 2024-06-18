package com.shoppingCart.ShoppingCart.security.service;

import com.shoppingCart.ShoppingCart.security.dto.UserRequest;
import com.shoppingCart.ShoppingCart.security.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    
    UserResponse getUserById(int userId);
    UserResponse getUserByUsername(String username);
    UserResponse saveUser(UserRequest user);
    boolean deleteUserById(int userId);
}
