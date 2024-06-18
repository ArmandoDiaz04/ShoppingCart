package com.shoppingCart.ShoppingCart.security.controller;

import com.shoppingCart.ShoppingCart.security.dto.AuthResponse;
import com.shoppingCart.ShoppingCart.security.dto.LoginRequest;
import com.shoppingCart.ShoppingCart.security.dto.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@Tag(name = "auth API", description = "auth endpoints")
@RequestMapping("/auth")
public interface AuthController {
    
    /**
     * authenticates the user by means of credentials
     * @param login
     * @param result
     * @return
     */
    @Operation(description = "login user")
    @ApiResponses(value = {@ApiResponse(responseCode="201",description="Succeded")})
    @PostMapping("/login")
    default ResponseEntity<?> login(@Valid @RequestBody LoginRequest login, BindingResult result) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    /**
     * create new client user
     * @param user
     * @param result
     * @return
     */
    @Operation(description = "Save user information", summary = "Return 201 if data is good")
    @ApiResponses(value = {@ApiResponse(responseCode="201",description="Succeded")})
    @PostMapping("/register")
    default ResponseEntity<?> register(@Valid @RequestBody UserRequest user, BindingResult result) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(description = "refresh user token")
    @ApiResponses(value = {@ApiResponse(responseCode="201",description="Succeded")})
    @GetMapping("/refresh")
    default ResponseEntity<?> refreshToken(@Valid @RequestBody AuthResponse authResponse, BindingResult result) throws ParseException {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


}
