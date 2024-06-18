package com.shoppingCart.ShoppingCart.security.dto;

import com.shoppingCart.ShoppingCart.security.models.Role;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Setter
@Getter
@RequiredArgsConstructor
public class UserResponse {
    private Integer userId;
    private String name;
    private String email;
    private String username;
    private boolean active;
    private Set<Role> roles = new HashSet<>();
    
    public UserResponse(String name, String email, String username, boolean active, Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.active = active;
        this.roles = roles;
    }

    
}
