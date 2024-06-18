package com.shoppingCart.ShoppingCart.security.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    
    @Autowired
    JwtProvider provider;

    @Autowired
    UserDetailsService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info(ALREADY_FILTERED_SUFFIX);
        
        try {
            String token = getToken(request);
            if (token !=null && provider.validateToken(token) ){
                String username = provider.getUsernameFromToken(token);

                UserDetails userDetails = service.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            log.error("Error en dofilterchain", e);
        }

        filterChain.doFilter(request, response);
            
    }

    /**
     * get token from htto request
     * @param request
     * @return
     */
    private String  getToken(HttpServletRequest request) {
        
        String header = request.getHeader("Authorization");

        if (header!=null && header.startsWith("Bearer")) {
            return header.replace("Bearer", "");
        }

        return null;
    }

}
