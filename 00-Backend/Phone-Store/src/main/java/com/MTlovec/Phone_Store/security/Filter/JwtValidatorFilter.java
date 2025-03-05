package com.MTlovec.Phone_Store.security.Filter;

import com.MTlovec.Phone_Store.constant.ApplicationConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

public class JwtValidatorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt= request.getHeader(ApplicationConstant.JWT_HEADER);
        if (jwt!=null){
            jwt= jwt.substring(7);
             SecretKey secretKey= Keys.hmacShaKeyFor(ApplicationConstant.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
             if(secretKey!=null){
                 Claims claims= Jwts.parser().verifyWith(secretKey)
                         .build().parseSignedClaims(jwt).getPayload();
                 Date expiration=claims.getExpiration();
                 if (expiration.before(new Date())){
                     throw new BadCredentialsException("Token is expired.Please sign up again");
                 }
                 String email= String.valueOf(claims.get("email"));
                 String authority= String.valueOf(claims.get("authorities"));
                 List<GrantedAuthority> grandAuth= AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
                 Authentication authentication= new UsernamePasswordAuthenticationToken(email, null,grandAuth );
                 SecurityContextHolder.getContext().setAuthentication(authentication);
             }
        }
        filterChain.doFilter(request, response);
    }
}
