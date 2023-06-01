package com.ppt.ppt.utils;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

/**
 * @author Mahesh
 */
@Component
public class JWTUtil {
    @Value("${security.jwt.secret}")
    private String key;

    @Value("${security.jwt.issuer}")
    private String issuer;

    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;

    private final Logger log = LoggerFactory
            .getLogger(JWTUtil.class);

    /**
     * Create a new token.
     *
     * @param id
     * @param subject
     * @return
     */
    public String create(String id, String subject) {
        // The JWT signature algorithm used to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // Obtener la fecha actual
        Instant now = Instant.now();

        // Crear una clave secreta a partir de la cadena de texto proporcionada
        byte[] apiKeySecretBytes = Base64.getDecoder().decode(key);
        SecretKey secretKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Construir el JWT
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer(issuer)
                .setIssuedAt(Date.from(now))
                .signWith(signatureAlgorithm, secretKey);

        if (ttlMillis >= 0) {
            // Calcular la fecha de expiración a partir de la fecha actual y el tiempo de expiración en milisegundos
            Instant expiration = now.plusMillis(ttlMillis);
            builder.setExpiration(Date.from(expiration));
        }

        // Generar el token JWT como una cadena compacta
        return builder.compact();
    }


    /**
     * Method to validate and read the JWT
     *
     * @param jwt
     * @return
     */
    public String getValue(String jwt) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(Base64.getDecoder().decode(key))
                    .parseClaimsJws(jwt)
                    .getBody();

            return claims.getSubject();
        } catch (JwtException e) {
            // Manejar la excepción en caso de un token inválido
            // Puedes lanzar una excepción personalizada, retornar null o realizar alguna otra acción apropiada
            log.error("Error al decodificar y validar el token JWT: {}", e.getMessage());
            return null;
        }
    }

    /**
     * Method to validate and read the JWT
     *
     * @param jwt
     * @return
     */
    public String getKey(String jwt) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(Base64.getDecoder().decode(key))
                    .parseClaimsJws(jwt)
                    .getBody();

            return claims.getId();
        } catch (JwtException e) {
            // Manejar la excepción en caso de un token inválido
            // Puedes lanzar una excepción personalizada, retornar null o realizar alguna otra acción apropiada
            log.error("Error al decodificar y validar el token JWT: {}", e.getMessage());
            return null;
        }
    }
}