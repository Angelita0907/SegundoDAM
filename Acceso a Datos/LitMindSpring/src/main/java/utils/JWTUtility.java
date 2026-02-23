package utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class JWTUtility {

	private static final Logger logger = LogManager.getLogger(JWTUtility.class);

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private long jwtExpirationMs;

	private Key key;

	public boolean validateJwtToken(String token) {
		boolean valido = false;
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			valido = true;
		} catch (SecurityException e) {
			logger.error("Invalid JWT signature: " + e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: " + e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: " + e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: " + e.getMessage());
		}
		return valido;
	}

	public String getUsernameFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	@PostConstruct
	public void init() {
		this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
	}

}
