package edu.mum.ea.miniproject.userauth.service;

import edu.mum.ea.miniproject.userauth.security.model.UserPrincipal;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    private String secret;
    private Long expiration;

    public JwtTokenProvider(@Value("${jwt.secret}") String secret,
                            @Value("${jwt.expiration}") Long expiration){
        this.secret = secret;
        this.expiration = expiration;
    }
    public String   generateToken(Authentication authentication){

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }
    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 10000);
    }
    public boolean validateToken(String jwt) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt);
            return true;
        } catch (SignatureException ex) {
            ex.printStackTrace();
        } catch (MalformedJwtException ex) {
            ex.printStackTrace();
        } catch (ExpiredJwtException ex) {
            ex.printStackTrace();
        } catch (UnsupportedJwtException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
           ex.printStackTrace();
        }
        return false;


    }
    public String getUserNameFromToken(String token){
        return  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
}
