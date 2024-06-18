package com.shoppingCart.ShoppingCart.security.service.imp;

import com.shoppingCart.ShoppingCart.security.configuration.JwtProvider;
import com.shoppingCart.ShoppingCart.security.dto.AuthResponse;
import com.shoppingCart.ShoppingCart.security.dto.LoginRequest;
import com.shoppingCart.ShoppingCart.security.dto.UserRequest;
import com.shoppingCart.ShoppingCart.security.dto.UserResponse;
import com.shoppingCart.ShoppingCart.security.models.Role;
import com.shoppingCart.ShoppingCart.security.models.RoleName;
import com.shoppingCart.ShoppingCart.security.models.User;
import com.shoppingCart.ShoppingCart.security.repository.UserRepository;
import com.shoppingCart.ShoppingCart.security.service.AuthService;
import com.shoppingCart.ShoppingCart.security.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    ModelMapper modelMapper;

     @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

         Authentication authentication=
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);

        User user = userRepository.findByUsername(username).orElse(null);

        UserResponse userResponse = modelMapper.map(user, UserResponse.class);


        return new AuthResponse(userResponse, jwt);

        
    }

    @Override
    public UserResponse register(UserRequest user) {
        
        /*
         * Verificar si el user es null para terminar el request
         */
        if (user == null) {
            return new UserResponse(null, null, null, false, null);
        }
        
        //mapear el userRequest a un user
        User newUser = modelMapper.map(user, User.class);
        
        //Setear los roles de string - Role || codificar password
        Set<Role> roles = setRoles(user.getRoles());
        String encodePassword = passwordEncoder.encode(newUser.getPassword());

        newUser.setPassword(encodePassword);
        newUser.setRoles(roles);


        UserResponse response = modelMapper.map(userRepository.save(newUser), UserResponse.class);
        return response;
    }
    
    @Override
    public Set<Role> setRoles(Set<String> roleList){
        Set<Role> roles = new HashSet<>();
        
        if (roleList.contains("admin")) {
            roles.add(roleService.findRoleByName(RoleName.ADMIN_ROLE));

            return roles;
        } else if( roleList.contains("user")){
            roles.add(roleService.findRoleByName(RoleName.USER_ROLE));
            return roles;
        }

        roles.add(roleService.findRoleByName(RoleName.CLIENT_ROLE));
        
        return roles;
    }
    
    @Override
    public AuthResponse refreshToken(AuthResponse authResponse) throws ParseException{

        String refreshToken = jwtProvider.refreshToken(authResponse.getToken());
        authResponse.setToken(refreshToken);
        return authResponse;
    }

}
