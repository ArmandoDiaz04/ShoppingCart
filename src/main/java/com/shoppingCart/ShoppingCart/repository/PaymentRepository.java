package com.shoppingCart.ShoppingCart.repository;

import com.shoppingCart.ShoppingCart.models.Order;
import com.shoppingCart.ShoppingCart.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    /**
     * Get payment by order
     * @param idOrder
     * @return
     */
    Optional<Payment> findByIdOrder(Order idOrder);

}
