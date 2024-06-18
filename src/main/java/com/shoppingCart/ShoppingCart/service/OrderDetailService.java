package com.shoppingCart.ShoppingCart.service;

import com.shoppingCart.ShoppingCart.dto.OrderDetailDto;
import com.shoppingCart.ShoppingCart.dto.OrderResponse;
import com.shoppingCart.ShoppingCart.dto.ProductResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {

    List<OrderDetailDto> getDetailsByOrder(OrderResponse idOrder);

    OrderDetailDto getDetailById(int idOrderDetail);

    OrderDetailDto saveOrderDetail(OrderDetailDto orderDetailDto);

    boolean deleteDetail(int idOrderDetail);

    ProductResponse getProduct(int idProduct);

}
