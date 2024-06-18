package com.shoppingCart.ShoppingCart.security.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UserDetailsImp implements UserDetails {

    private String username;
    private String password;
    private boolean active;
    private Collection<? extends GrantedAuthority> authorities;

    

    public UserDetailsImp(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = this.setRoles(user.getRoles());
    }

    public static UserDetailsImp build(User user){
        
        UserDetailsImp userDetailsImp = new UserDetailsImp(user);

        return userDetailsImp;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public List<GrantedAuthority> setRoles(Set<Role> roles){
        List<GrantedAuthority> auths = new ArrayList<>();

        for (Role role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getRoleName().name()));
        }
        return auths;
    }

}
