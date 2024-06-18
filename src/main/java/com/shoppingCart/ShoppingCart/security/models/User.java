package com.shoppingCart.ShoppingCart.security.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoppingCart.ShoppingCart.models.Order;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean active;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser", fetch = FetchType.LAZY)
    private List<Order> orders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();
}

