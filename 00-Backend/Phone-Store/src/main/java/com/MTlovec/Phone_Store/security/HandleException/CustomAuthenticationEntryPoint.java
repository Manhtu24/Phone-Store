package com.MTlovec.Phone_Store.security.HandleException;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.ManyToOne;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationEntryPoint  implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Map<String, Object> errorBody=new HashMap<>();
        errorBody.put("status",HttpStatus.UNAUTHORIZED.value());
        errorBody.put("message",authException.getMessage());
        errorBody.put("error","UNAUTHORIZED");
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("path",request.getRequestURL());
        new ObjectMapper().writeValue(response.getOutputStream(),errorBody);
    }
}
