package com.backend.core.users.infrastructure.adapters;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.backend.core.users.domain.exception.UnAuthorizedException;
import com.backend.core.users.domain.models.UserModel;
import com.backend.core.users.domain.spi.TokenAuthenticatePort;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenAuthenticatedAdapter implements TokenAuthenticatePort{

    @Value("${application.auth.secret}")
    private String secret;

    @Override
    public String createToken(UserModel userModel) {
        final Date now = new Date();
        Date expirationDate = new Date(now.getTime() + (3600 * 1000));

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", userModel.getEmail());
        claims.put("role", userModel.getRole().getName() );

        return Jwts
                .builder()
                .subject(userModel.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expirationDate)
                .claims(claims)
                .signWith(this.getSecretKey())
                .compact();
    }

    @Override
    public String validateToken(String bearerToken) {

        if( bearerToken == null || bearerToken.isEmpty() || !bearerToken.startsWith("Bearer ") ){
            throw new UnAuthorizedException(HttpStatus.UNAUTHORIZED.value(), "No tiene permisos.");
        }
        String token = bearerToken.substring(7);
        final Claims claims = signToken(token);
        final Date expirationDate = this.getExpirationDate(claims);
        final String email = this.getSubject(claims);
        if( !expirationDate.after(new Date()) ) {
            throw new UnAuthorizedException(HttpStatus.UNAUTHORIZED.value(), "No tiene permisos.");
        }
        return email;
    }

    private String getSubject(Claims claims){
        return this.getClaimsFromToken(claims, Claims::getSubject );
    }

    private Date getExpirationDate(Claims claims){
        return this.getClaimsFromToken(claims, Claims::getExpiration);
    }

    private <T> T getClaimsFromToken(Claims claims, Function<Claims, T> resolver) {
        return resolver.apply(claims);
    }

    private Claims signToken(String token){
        return Jwts
            .parser()
            .verifyWith(getSecretKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }


    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(this.secret.getBytes(StandardCharsets.UTF_8));
    }
    
}
