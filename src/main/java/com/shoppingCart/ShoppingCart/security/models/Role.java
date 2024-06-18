package com.shoppingCart.ShoppingCart.security.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Role implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;
}
