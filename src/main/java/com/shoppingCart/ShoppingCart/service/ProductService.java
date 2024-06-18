package com.shoppingCart.ShoppingCart.service;

import com.shoppingCart.ShoppingCart.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    
    List<ProductResponse> getAllProducts();

    ProductResponse getASingleProduct(Integer id);

}
