package com.shoppingCart.ShoppingCart.service.imp;

import com.shoppingCart.ShoppingCart.client.ProductServiceClient;
import com.shoppingCart.ShoppingCart.dto.ProductResponse;
import com.shoppingCart.ShoppingCart.exception.ProductNotFoundException;
import com.shoppingCart.ShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductServiceClient productServiceClient;

    @Override
    public List<ProductResponse> getAllProducts() {
        return productServiceClient.findAllProducts();
    }

    @Override
    public ProductResponse getASingleProduct(Integer id) {
        return Optional.ofNullable(productServiceClient.getASingleProduct(id)).orElseThrow(() -> new ProductNotFoundException(String.format(" - %s", id)));
    }
    
}
