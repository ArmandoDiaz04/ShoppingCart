package com.shoppingCart.ShoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class PaymentRequest {
    @Schema(name = "idPayment",required = false,example = "1",defaultValue = "2",description = "This key is autogenerated, it's not necesary")
    private Integer idPayment;
    @Schema(name = "idOrder",required = true,example = "1",defaultValue = "2",description = "this key is to indicate the id order")
    @NotNull
    @JsonBackReference
    private OrderResponse idOrder;
    @Schema(name = "paymentType",required = true,example = "cash",defaultValue = "cash",description = "this key is to indicate the payment type")
    @NotBlank
    private String paymentType;
    @Schema(name = "status",required = true,example = "pending",defaultValue = "pending",description = "this key indicates the status of the payment")
    @NotBlank
    private String status;
}