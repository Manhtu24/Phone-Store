package com.MTlovec.Phone_Store.security;

import com.MTlovec.Phone_Store.constant.ApplicationConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JWTGenerator {
    private SecretKey secretKey= Keys.hmacShaKeyFor(ApplicationConstant.JWT_SECRET_KEY.getBytes());

    public  String  GenerateToken(Authentication authentication){

        String jwt= Jwts.builder().issuer("BMT").subject("JWT Token")
                .claim("email",authentication.getName() )
                .claim("authorities", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(",")))
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime()+864000))
                .signWith(secretKey)
                .compact();
        log.info("Generate success jwt");
        log.info("authorities",authentication.getAuthorities());
        return jwt;
    }
    public String getEmailFromJWT(String jwt){
        String subJWT= jwt.substring(7);
        Claims claims= Jwts.parser().verifyWith(secretKey)
                .build().parseSignedClaims(subJWT).getPayload();
        String email= String.valueOf(claims.get("email"));
        return email;
    }

}
