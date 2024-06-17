package com.shoppingCart.ShoppingCart.security.service;

import com.shoppingCart.ShoppingCart.security.models.UserEntity;
import com.shoppingCart.ShoppingCart.security.repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity =  userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario: " + username + "no existe."));

        Collection<? extends GrantedAuthority> authorities = userEntity.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
                .collect(Collectors.toSet());
        return new User(userEntity.getUserName(),
                userEntity.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }
}
