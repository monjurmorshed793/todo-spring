package com.morshed.todo.security.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginResource {
    private final JwtEncoder encoder;
    @Value("${jwt.token.expiration}")
    public String tokenExpirationDay;
    private record Token(String token){};

    @PostMapping("/login")
    public Token login(Authentication authentication){
        Instant now = Instant.now();
        Instant expirationTime = now.plus(Long.parseLong(tokenExpirationDay), ChronoUnit.DAYS);

        String scope = authentication.getAuthorities().stream()
                .map((GrantedAuthority::getAuthority))
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(expirationTime)
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        return new Token(this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
    }
}
