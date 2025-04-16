package com.MTlovec.Phone_Store.security.HandleException;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Map<String, Object> errorBody=new HashMap<>();
        errorBody.put("status",HttpStatus.FORBIDDEN.value());
        errorBody.put("message",accessDeniedException.getMessage());
        errorBody.put("error","UNAUTHORIZED");
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("path",request.getRequestURL());
        new ObjectMapper().writeValue(response.getOutputStream(),errorBody);
    }
}
