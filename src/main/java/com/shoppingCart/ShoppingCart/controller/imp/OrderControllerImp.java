package com.shoppingCart.ShoppingCart.controller.imp;

import com.shoppingCart.ShoppingCart.controller.OrderController;
import com.shoppingCart.ShoppingCart.dto.OrderRequest;
import com.shoppingCart.ShoppingCart.dto.OrderResponse;
import com.shoppingCart.ShoppingCart.security.dto.UserResponse;
import com.shoppingCart.ShoppingCart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderControllerImp implements OrderController {

    @Autowired
    OrderService orderService;

    @Override
    public ResponseEntity<?> createOrder(OrderRequest order, BindingResult result) {
        if (result.hasErrors()) 
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en los campos");
        OrderResponse response = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<?> findOrderByUser(UserResponse user, BindingResult result) {
        if (result.hasErrors()) 
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en los campos");
        List<OrderResponse> response = orderService.getOrderByUsuario(user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<?> updateOrder(OrderRequest order, BindingResult result) {
        if (result.hasErrors()) 
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en los campos");
        OrderResponse response = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
