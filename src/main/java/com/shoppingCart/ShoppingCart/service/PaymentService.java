package com.shoppingCart.ShoppingCart.service;

import com.shoppingCart.ShoppingCart.dto.OrderResponse;
import com.shoppingCart.ShoppingCart.dto.PaymentRequest;
import com.shoppingCart.ShoppingCart.dto.PaymentResponse;
import com.shoppingCart.ShoppingCart.models.PaymentStatus;
import com.shoppingCart.ShoppingCart.models.PaymentType;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    PaymentResponse getPaymentById(int idPayment);

    PaymentResponse getPaymentByOrder(OrderResponse idOrder);

    PaymentResponse savePayment(PaymentRequest payment);

    PaymentStatus setPaymentStatus(String status);

    PaymentType setPaymentType(String type);

}
