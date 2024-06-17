package com.shoppingCart.ShoppingCart;

import com.shoppingCart.ShoppingCart.security.models.ERole;
import com.shoppingCart.ShoppingCart.security.models.RoleEntity;
import com.shoppingCart.ShoppingCart.security.models.UserEntity;
import com.shoppingCart.ShoppingCart.security.repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Bean
	CommandLineRunner init(){
		return args -> {
			UserEntity userEntity = UserEntity.builder()
					.status(true)
					.email("armando@gmail.com")
					.userName("armando")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder().name(ERole.valueOf(ERole.USER.name()))
							.build()))

					.build();

			userRepository.save(userEntity);
		};
	}

}
