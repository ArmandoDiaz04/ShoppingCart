package com.shoppingCart.ShoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductResponse extends RepresentationModel<ProductResponse> {

    // ID of the product, generated from another API.
    @JsonProperty("id")
    @Schema(name = "productId", required = true, example = "1", defaultValue = "2", description = "This key is generated from another API")
    private Integer productId;

    // Name of the product, generated from another API.
    @JsonProperty("title")
    @Schema(name = "name", required = true, example = "product name", defaultValue = "product name", description = "This key is generated from another API")
    private String name;

    // Description of the product, generated from another API.
    @JsonProperty("description")
    @Schema(name = "description", required = true, example = "product description", defaultValue = "product description", description = "This key is generated from another API")
    private String description;

    // URL of the product image, generated from another API.
    @Schema(name = "imageUrl", required = true, example = "image url", defaultValue = "image url", description = "This key is generated from another API")
    @JsonProperty("image")
    private String imageUrl;

    // Price of the product, generated from another API. Default value is 0.
    @Schema(name = "price", required = true, example = "product price", defaultValue = "product price", description = "This key is generated from another API")
    @JsonProperty("price")
    private double price = 0;

}
