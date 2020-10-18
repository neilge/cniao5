package io.neo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.neo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author Neo
 * @since 10/11/2020-11:25 PM
 */
@ConfigurationProperties("config.jwt")
@Component
public class JwtUtil {

    @Autowired
    AccountService accountService;

    private String secret;
    private long expire;

    public String generateToken(String mobi) {
        return Jwts.builder()
                .setSubject(mobi)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean validateToken(String token) {
        return isMobiValidated(token) && !isTokenExpired(token);
    }

    private boolean isMobiValidated(String token) {
        String mobi = extractMobi(token);
        return !Objects.isNull(accountService.getAccountByMobi(mobi));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date(System.currentTimeMillis()));
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private String extractMobi(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim
            (String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }
}
