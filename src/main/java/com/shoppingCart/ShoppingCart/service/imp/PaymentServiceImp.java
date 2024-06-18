package com.shoppingCart.ShoppingCart.service.imp;

import com.shoppingCart.ShoppingCart.dto.OrderResponse;
import com.shoppingCart.ShoppingCart.dto.PaymentRequest;
import com.shoppingCart.ShoppingCart.dto.PaymentResponse;
import com.shoppingCart.ShoppingCart.exception.InvalidParameterValueException;
import com.shoppingCart.ShoppingCart.exception.ResourceNotFoundException;
import com.shoppingCart.ShoppingCart.models.Order;
import com.shoppingCart.ShoppingCart.models.Payment;
import com.shoppingCart.ShoppingCart.models.PaymentStatus;
import com.shoppingCart.ShoppingCart.models.PaymentType;
import com.shoppingCart.ShoppingCart.repository.PaymentRepository;
import com.shoppingCart.ShoppingCart.service.OrderService;
import com.shoppingCart.ShoppingCart.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentServiceImp implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OrderService orderService;

    @Override
    public PaymentResponse getPaymentById(int idPayment) {
        Payment payment = paymentRepository.findById(idPayment).orElseThrow(() -> new ResourceNotFoundException(String.format(" Payment not exists - %s", idPayment)));
        PaymentResponse paymentResponse = modelMapper.map(payment, PaymentResponse.class);
        return paymentResponse;
    }


    @Override
    public PaymentResponse getPaymentByOrder(OrderResponse idOrder) {
        if (idOrder == null) {
            throw new InvalidParameterValueException(String.format("Invalid value. Null is not valid value - %s", idOrder));
        }
        
        Order orderEntity = modelMapper.map(idOrder, Order.class);
        Payment payment = paymentRepository.findByIdOrder(orderEntity).orElseThrow(() -> new ResourceNotFoundException(String.format(" Payment not exists to order with id - %s",idOrder)));
        PaymentResponse paymentResponse = modelMapper.map(payment, PaymentResponse.class);
        return paymentResponse;
    }

    @Override
    public PaymentResponse savePayment(PaymentRequest paymentRequest) {

        if (paymentRequest == null) {
            throw new InvalidParameterValueException(String.format("Invalid value. Null is not valid value - %s", paymentRequest));
        }

        //verificando si existe el registro para no crear uno nuevo
        if (paymentRequest.getIdPayment() != null) {
            int idPaymentExist = paymentRequest.getIdPayment();
            Payment paymentExist = paymentRepository.findById(idPaymentExist).get();
            PaymentStatus status = setPaymentStatus(paymentRequest.getStatus());
            PaymentType paymentType = setPaymentType(paymentRequest.getPaymentType());
            paymentExist.setStatus(status);
            paymentExist.setPaymentType(paymentType);
            PaymentResponse response = modelMapper.map(paymentExist,PaymentResponse.class);
            orderService.setOrderStatusByPayment(status.name(), paymentExist.getIdOrder().getIdOrder());

            return response;
        }

        Payment payment = modelMapper.map(paymentRequest, Payment.class);

        //seteando estado y tipo de pago
        PaymentStatus paymentStatus = setPaymentStatus(paymentRequest.getStatus());
        PaymentType paymentType = setPaymentType(paymentRequest.getPaymentType());

        //Obteniendo id de la orden
        int idOrder = paymentRequest.getIdOrder().getIdOrder();

        payment.setPaymentType(paymentType);
        payment.setStatus(paymentStatus);

        OrderResponse orderResponse =  orderService.setOrderStatusByPayment(paymentStatus.name(), idOrder);
        
        PaymentResponse paymentResponse = modelMapper.map(paymentRepository.save(payment), PaymentResponse.class);

        paymentResponse.setIdOrder(orderResponse);

        return paymentResponse;
    }

    @Override
    public PaymentStatus setPaymentStatus(String status) {
        PaymentStatus newStatus =  null;

        switch (status.toLowerCase()) {
            case "pending":
                newStatus= PaymentStatus.PENDING;
                break;
            case "completed":
                newStatus= PaymentStatus.COMPLETED;
                break;
            case "declined":
                newStatus= PaymentStatus.DECLINED;
                break;
            case "canceled":
                newStatus= PaymentStatus.CANCELED;
                break;
            case "refund":
                newStatus= PaymentStatus.REFUND;
                break;
        }

        return newStatus;
    }

    public PaymentType setPaymentType(String type) {
        PaymentType newType =  null;

        switch (type.toLowerCase()) {
            case "credit_card":
                newType= PaymentType.CREDIT_CARD;
                break;
            case "debit_card":
                newType= PaymentType.DEBIT_CARD;
                break;
            case "transfer":
                newType= PaymentType.TRANSFER;
                break;
            case "cash":
                newType= PaymentType.CASH;
                break;
        }

        return newType;
    }

}
