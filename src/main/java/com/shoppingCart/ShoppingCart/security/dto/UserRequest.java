package com.shoppingCart.ShoppingCart.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Setter
@Getter
public class UserRequest {
    @Schema(name = "userId",required = false,example = "1",defaultValue = "2",description = "This key is autogenerated, it's not necesary")
    private Integer userId;

    @Schema(name = "name",required = true,example = "user name",defaultValue = "user name",description = "This key indicates the user name")
    @NotBlank
    private String name;

    @Schema(name = "email",required = true,example = "user email",defaultValue = "user email",description = "This key indicates the user email")
    @NotBlank
    @Email
    private String email;

    @Schema(name = "username",required = true,example = "username",defaultValue = "username",description = "This key indicates the username")
    @NotBlank
    private String username;

    @Schema(name = "password",required = true,example = "password",defaultValue = "password",description = "This key indicates the password")
    @NotBlank
    private String password;

    @Schema(name = "active",required = true,example = "true",defaultValue = "true",description = "this key indicates whether the user is active")
    private boolean active;
    
    @Schema(name = "roles",required = true,example = "roles",defaultValue = "roles",description = "this key indicates the user roles")
    @NotNull
    private Set<String> roles = new HashSet<>();
}
