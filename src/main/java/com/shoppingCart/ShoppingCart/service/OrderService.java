package com.shoppingCart.ShoppingCart.service;

import com.shoppingCart.ShoppingCart.dto.OrderRequest;
import com.shoppingCart.ShoppingCart.dto.OrderResponse;
import com.shoppingCart.ShoppingCart.models.Order;
import com.shoppingCart.ShoppingCart.models.OrderDetail;
import com.shoppingCart.ShoppingCart.models.OrderStatus;
import com.shoppingCart.ShoppingCart.security.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    OrderResponse saveOrder(OrderRequest orderRequest);
    OrderResponse getOrderById(int idOrder);
    List<OrderResponse> getOrderByUsuario(UserResponse userResponse);
    OrderStatus changeOrderStatus(String orderStatus);
    void updateOrderTotal(List<OrderDetail> detailsList, Order order);
    public OrderResponse setOrderStatusByPayment(String paymentStatus, int idOrder);

}
