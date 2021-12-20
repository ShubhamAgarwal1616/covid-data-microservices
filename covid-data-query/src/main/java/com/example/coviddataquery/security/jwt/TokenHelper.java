package com.example.coviddataquery.security.jwt;

import com.example.coviddataquery.security.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TokenHelper {
    private final JwtProperties jwtProperties;
    private static final String AUDIENCE_WEB = "web";
    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    public String getUsernameFromToken(String token) {
        String username = null;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            if (claims == null) {
                return null;
            }
            username = claims.getSubject();
        } catch (Exception e) {
//            log.error(e.getMessage(), e);
        }
        return username;
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
//            log.error(e.getMessage(), e);
        }
        return claims;
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setIssuer(jwtProperties.getIssuer())
                .setSubject(username)
                .setAudience(AUDIENCE_WEB)
                .setIssuedAt(new Date())
                .setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALGORITHM, jwtProperties.getSecret())
                .compact();
    }

    private Date generateExpirationDate() {
        return new Date(new Date().getTime() + jwtProperties.getExpiresIn() * 1000);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return username != null && username.equals(userDetails.getUsername());
    }

    public String getToken(HttpServletRequest request) {
        String authHeader = getAuthHeaderFromHeader(request);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    private String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader(jwtProperties.getHeader());
    }

}
