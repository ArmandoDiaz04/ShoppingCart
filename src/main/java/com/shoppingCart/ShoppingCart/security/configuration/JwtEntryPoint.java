package com.shoppingCart.ShoppingCart.security.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingCart.ShoppingCart.dto.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class JwtEntryPoint implements AuthenticationEntryPoint {@Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
                
        log.error("Error en metodo commence entry point");

                //res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
        Message mensaje = new Message("token inválido o vacío");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(mensaje));
        response.getWriter().flush();
        response.getWriter().close();
    }

}
