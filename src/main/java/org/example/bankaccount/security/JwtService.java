package org.example.bankaccount.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.bankaccount.entity.UserBank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final SecretKey secretKey;

    public JwtService(@Value("${jwttoken.signing.key}") String jwtSecretKey) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecretKey));
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        if(userDetails instanceof UserBank userBank){
            claims.put("userId", userBank);
            claims.put("login", userBank.getLogin());
            claims.put("role", userBank.getRole().name());
        }
        return generateToken(userDetails, claims);
    }

    private String generateToken(UserDetails userDetails, Map<String, Object> claims){
        return Jwts.builder()
                .claims()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + (1000 * 86400)))
                .subject(userDetails.getUsername())
                .add(claims)
                .and()
                .signWith(secretKey)
                .compact();
    }

    public String extractUserBankName(String jwt){
        if(jwt == null) throw new NullPointerException("Jwt can not be NULL");
        return extractClaims(jwt, Claims::getSubject);
    }

    public boolean isTokenValid (String jwt, UserDetails userDetails){
        String userBankName = extractUserBankName(jwt);
        return userDetails.getUsername().equals(userBankName) &&
                !isExpired(jwt);
    }

    private boolean isExpired(String jwt){
        return extractExpiration(jwt).before(new Date());
    }

    private Date extractExpiration(String jwt){
        return extractClaims(jwt, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        try {
            if (token.contains(" ")) throw new Exception("Token contains a SPACE");
        } catch (Exception e) {
            e.getMessage();
        }
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseSignedClaims(token.trim())
                .getPayload();
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction){
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }
}
