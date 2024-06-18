package com.shoppingCart.ShoppingCart.controller;

import com.shoppingCart.ShoppingCart.dto.OrderResponse;
import com.shoppingCart.ShoppingCart.dto.PaymentRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("/api/v1/payments")
public interface PaymentController {

    /**
     * get payment by order
     * @param idOrder
     * @param result
     * @return
     */
    @GetMapping( path = "/by-order", produces = {"application/json"})
    default ResponseEntity<?> findPaymentByOrder(  @Valid @RequestBody OrderResponse idOrder, BindingResult result){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * create payment of order
     * @param paymentRequest
     * @param result
     * @return
     */
    @PostMapping(produces = {"application/json"})
    default ResponseEntity<?> createPayment(@Valid @RequestBody PaymentRequest paymentRequest, BindingResult result){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * update payment
     * @param paymentRequest
     * @param result
     * @return
     */
    @PutMapping(produces = {"application/json"})
    default ResponseEntity<?> updatePayment(@Valid @RequestBody PaymentRequest paymentRequest, BindingResult result){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


}
