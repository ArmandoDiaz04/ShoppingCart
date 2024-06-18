package com.shoppingCart.ShoppingCart.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class LoginRequest {

    @Schema(name = "username",required = true,example = "username",defaultValue = "username",description = "This key indicates the username")
    @NotBlank
    private String username;

    @Schema(name = "password",required = true,example = "password",defaultValue = "password",description = "This key indicates the password")
    @NotBlank
    private String password;

}