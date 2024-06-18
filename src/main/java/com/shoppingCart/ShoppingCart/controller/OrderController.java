package com.shoppingCart.ShoppingCart.controller;


import com.shoppingCart.ShoppingCart.dto.OrderRequest;
import com.shoppingCart.ShoppingCart.security.dto.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Tag(name = "orders API", description = "orders endpoints")
@RequestMapping("/api/v1/orders")
public interface OrderController {
    
    /**
     * Get all orders by user
     * @param user
     * @param result
     * @return 
     * 
     */
    @Operation(description = "Return all orders by user")
    @ApiResponses(value = {@ApiResponse(responseCode="200",description="Success")})
    @GetMapping(produces = {"application/json"})
    default ResponseEntity<?> findOrderByUser(@Valid @RequestBody UserResponse user, BindingResult result){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * create a new order
     * @param order
     * @param result
     * @return
     */
    @Operation(description = "Save order information", summary = "Return 201 if data is good")
    @ApiResponses(value = {@ApiResponse(responseCode="201",description="Succeded")})
    @PostMapping(produces = {"application/json"})
    default ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest order, BindingResult result){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * update order 
     * @param order
     * @param result
     * @return
     */
    @Operation(description = "Update order information", summary = "Return 404 if the order not exists")
    @ApiResponses(value = {@ApiResponse(responseCode="200",description="successful")})
    @PutMapping(produces = {"application/json"})
    default ResponseEntity<?> updateOrder(@Valid @RequestBody OrderRequest order, BindingResult result){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
