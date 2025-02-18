package com.MTlovec.Phone_Store.security.Filter;

import com.MTlovec.Phone_Store.constant.ApplicationConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JwtValidatorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt= request.getHeader(ApplicationConstant.JWT_HEADER);

        if (jwt!=null){
            jwt= jwt.substring(7)
             SecretKey secretKey= Keys.hmacShaKeyFor(ApplicationConstant.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
             if(secretKey!=null){
                 Claims claims= Jwts.parser().verifyWith(secretKey)
                         .build().parseSignedClaims(jwt).getPayload();
                 String email= String.valueOf(claims.get("email"));
                 
                 //Not Done yet;
             }


        }
    }
}
