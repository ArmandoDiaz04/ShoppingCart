package com.shoppingCart.ShoppingCart.repository;

import com.shoppingCart.ShoppingCart.models.Order;
import com.shoppingCart.ShoppingCart.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    /**
     * get orders by user
     * @param idUser
     * @return
     */
    Optional<List<Order>> findByIdUser(User idUser);

}
