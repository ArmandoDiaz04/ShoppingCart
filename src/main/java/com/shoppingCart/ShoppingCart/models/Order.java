package com.shoppingCart.ShoppingCart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shoppingCart.ShoppingCart.security.models.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;
    private double totalAmount;
    private int totalItems;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne(mappedBy = "idOrder", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Payment idPayment;
    @CreationTimestamp
    private Date creatDate;
    @UpdateTimestamp
    private Date updateDate;

    @JoinColumn(name = "id_user", referencedColumnName = "userId", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity idUser;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrder", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;
}
