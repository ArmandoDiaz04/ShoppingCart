package com.shoppingCart.ShoppingCart.controller.imp;

import com.shoppingCart.ShoppingCart.controller.PaymentController;
import com.shoppingCart.ShoppingCart.dto.OrderResponse;
import com.shoppingCart.ShoppingCart.dto.PaymentRequest;
import com.shoppingCart.ShoppingCart.dto.PaymentResponse;
import com.shoppingCart.ShoppingCart.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentControllerImp  implements PaymentController{

    @Autowired
    private PaymentService paymentService;

    @Override
    public ResponseEntity<?> createPayment(PaymentRequest paymentRequest, BindingResult result) {
        if (result.hasErrors()) 
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en los campos");
        PaymentResponse response = paymentService.savePayment(paymentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<?> findPaymentByOrder(OrderResponse idOrder, BindingResult result) {
        if (result.hasErrors()) 
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en los campos");
        PaymentResponse response = paymentService.getPaymentByOrder(idOrder);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<?> updatePayment(PaymentRequest paymentRequest, BindingResult result) {
        if (result.hasErrors()) 
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en los campos");
        PaymentResponse response = paymentService.savePayment(paymentRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
