package com.shoppingCart.ShoppingCart.dto;

import com.shoppingCart.ShoppingCart.security.dto.UserResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class OrderRequest {
    // Autogenerated ID for the order. Not necessary to provide.
    @Schema(name = "idOrder", required = false, example = "1", defaultValue = "2", description = "This key is autogenerated, it's not necessary")
    private Integer idOrder;

    // Automatically calculated total amount of the order. Not necessary to provide.
    @Schema(name = "totalAmount", required = false, example = "1", defaultValue = "2", description = "This key is autocalculate, it's not necessary")
    @PositiveOrZero
    private double totalAmount;

    // Total number of items in the order. Not necessary to provide.
    @Schema(name = "totalItems", required = false, example = "1", defaultValue = "2", description = "This key is to indicate the total items of order")
    @PositiveOrZero
    private int totalItems;

    // Status of the order. Must be provided and cannot be blank.
    @Schema(name = "status", required = true, example = "in progress", defaultValue = "in progress", description = "This key indicates the status of the order")
    @NotBlank
    private String status;

    // User associated with the order. Must be provided and cannot be null.
    @Schema(name = "idUser", example = "{\"userId\":1,\"name\":\"MauricioSanchez\",\"email\":\"mauricio.sanchez@gmail.com\",\"username\":\"msanchez\",\"active\":true,\"roles\":[{\"roleId\":3,\"roleName\":\"CLIENT_ROLE\"}]}", required = true, description = "This key indicates the user")
    @NotNull
    private UserResponse idUser;

    // Payment information associated with the order. Can be null.
    @Schema(name = "idPayment", required = true, example = "\"{\\\"idPayment\\\":3,\\\"paymentType\\\":\\\"DEBIT_CARD\\\",\\\"status\\\":\\\"PENDING\\\",\\\"creatDate\\\":\\\"2024-01-29T17:04:45.566+00:00\\\",\\\"updateDate\\\":\\\"2024-01-29T17:04:45.566+00:00\\\"}\"", description = "This key indicates payment")
    @Nullable
    private PaymentResponse idPayment;
}
