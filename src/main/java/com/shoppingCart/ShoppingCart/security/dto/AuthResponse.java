package com.shoppingCart.ShoppingCart.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class AuthResponse {
    private UserResponse user;
    private String token;

}
