package com.shoppingCart.ShoppingCart.controller;

import com.shoppingCart.ShoppingCart.dto.OrderDetailDto;
import com.shoppingCart.ShoppingCart.dto.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Tag(name = "order detail API", description = "order detail endpoints")
@RequestMapping("/api/v1/order-detail")
public interface OrderDetailController {
    
     /**
     * create a new detail of order
     * @param idOrder
     * @param result
     * @return
     */
    @Operation(description = "Return order details by order", summary = "Return 404 if no data found")
    @ApiResponses(value = {@ApiResponse(responseCode="200",description="successful")})
    @GetMapping( path = "/by-order", produces = {"application/json"})
    default ResponseEntity<List<?>> findOrderDetailByOrder(@Valid @RequestBody OrderResponse idOrder, BindingResult result){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * get order detail by id
     * @param idOrderDetail
     * @return
     */
    @Operation(description = "Return order details by id", summary = "Return 404 if no data found")
    @ApiResponses(value = {@ApiResponse(responseCode="200",description="successful")})    
    @GetMapping( path = "/{idOrderDetail}", produces = {"application/json"})
    default ResponseEntity<?> findOrderDetailById(@PathVariable int idOrderDetail){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * create a new order detail
     * @param orderDetail
     * @param result
     * @return
     */
    @Operation(description = "Save orderDetail information", summary = "Return 201 if data is good")
    @ApiResponses(value = {@ApiResponse(responseCode="201",description="Succeded")})
   @PostMapping(path = "", produces = {"application/json"})
    default ResponseEntity<?> createOrderDetail(@Valid @RequestBody OrderDetailDto orderDetail, BindingResult result){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * update order detail
     * @param idOrderDetail
     * @param orderDetail
     * @param result
     * @return
     */
    @Operation(description = "Update order detail information looking for id", summary = "Return 404 if the orde detail not exists")
    @ApiResponses(value = {@ApiResponse(responseCode="200",description="successful")})
    @PutMapping(path = "/{idOrderDetail}", produces = {"application/json"})
    default ResponseEntity<?> updateOrderDetail( @PathVariable("idOrderDetail") int idOrderDetail, @Valid @RequestBody OrderDetailDto orderDetail, BindingResult result){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * delete order detail
     * @param idOrderDetail
     * @return
     */
    @DeleteMapping(path = "/{idOrderDetail}")
    default ResponseEntity<?> deletedOrderDetail(@PathVariable int idOrderDetail){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
