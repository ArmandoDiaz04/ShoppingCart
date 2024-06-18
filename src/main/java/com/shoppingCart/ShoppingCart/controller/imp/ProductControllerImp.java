package com.shoppingCart.ShoppingCart.controller.imp;

import com.shoppingCart.ShoppingCart.controller.ProductController;
import com.shoppingCart.ShoppingCart.dto.ProductResponse;
import com.shoppingCart.ShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerImp implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    public ResponseEntity<ProductResponse> findById(int id) {
        return ResponseEntity.ok(productService.getASingleProduct(id));
    }
    
}
