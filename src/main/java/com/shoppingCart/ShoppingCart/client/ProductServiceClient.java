package com.shoppingCart.ShoppingCart.client;

import com.shoppingCart.ShoppingCart.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products", url = "https://fakestoreapi.com", path = "/products")
public interface ProductServiceClient {

    @GetMapping
    List<ProductResponse> findAllProducts();

    @GetMapping("/{id}")
    ProductResponse getASingleProduct(@PathVariable(name = "id") Integer id);

}