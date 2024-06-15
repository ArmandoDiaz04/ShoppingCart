package com.shoppingCart.ShoppingCart.security.controller;

import com.shoppingCart.ShoppingCart.security.dto.CreateUser;
import com.shoppingCart.ShoppingCart.security.models.ERole;
import com.shoppingCart.ShoppingCart.security.models.RoleEntity;
import com.shoppingCart.ShoppingCart.security.models.UserEntity;
import com.shoppingCart.ShoppingCart.security.repositoy.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    private PasswordEncoder passwordEncoder ;

    @Autowired
    private  UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/helloSecured")
    public String helloSecured() {
        return "Hello World Secured";
    }

    @PostMapping("CreateUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUser createUser){
        Set<RoleEntity> roles = createUser.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity =  UserEntity.builder()
                .email(createUser.getEmail())
                .userName(createUser.getUserName())
                .password(passwordEncoder.encode(createUser.getPassword()))
                .status(createUser.getStatus())
                .roles(roles)
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);

    }
    @DeleteMapping("deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "Deleted";

    }

}
