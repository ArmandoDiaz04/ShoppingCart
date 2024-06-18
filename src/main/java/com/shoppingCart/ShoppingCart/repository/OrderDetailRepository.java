package com.shoppingCart.ShoppingCart.repository;

import com.shoppingCart.ShoppingCart.models.Order;
import com.shoppingCart.ShoppingCart.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    /**
     * get order detail by order parent
     * @param idOrder
     * @return
     */
    Optional<List<OrderDetail>> findByIdOrder(Order idOrder);

}