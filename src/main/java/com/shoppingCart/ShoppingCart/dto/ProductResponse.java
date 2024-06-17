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

    @JsonProperty("id")
    @Schema(name = "productId",required = true,example = "1",defaultValue = "2",description = "This key is generated from other api")
    private Integer productId;

    @JsonProperty("title")
    @Schema(name = "name",required = true,example = "product name",defaultValue = "product name",description = "This key is generated from other api")
    private String name;

    @JsonProperty("description")
    @Schema(name = "description",required = true,example = "product description",defaultValue = "product description",description = "This key is generated from other api")
    private String description;

    @Schema(name = "imageUrl",required = true,example = "image url",defaultValue = "image url",description = "This key is generated from other api")
    @JsonProperty("image")
    private String imageUrl;

    @Schema(name = "price",required = true,example = "product price",defaultValue = "product price",description = "This key is generated from other api")
    @JsonProperty("price")
    private double price = 0;

}
