//package com.example.demo.security.config;
//
//import javax.crypto.SecretKey;
// import java.security.Key;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.ResponseCookie;
//import org.springframework.stereotype.Component;
//import org.springframework.web.util.WebUtils;
//
//import com.example.demo.service.UserDetailsServiceImpl;
//import com.example.demo.service.UserDetailsImpl;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.UnsupportedJwtException;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import lombok.Value;
//@Component
//public class JwtUtils {
//	 private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
//
//	 
//	  private String jwtSecret;
//
//	 
//	  private int jwtExpirationMs;
//
//	 
//	  private String jwtCookie;
//
//	  public String getJwtFromCookies(HttpServletRequest request) {
//	    Cookie cookie = WebUtils.getCookie(request, jwtCookie);
//	    if (cookie != null) {
//	      return cookie.getValue();
//	    } else {
//	      return null;
//	    }
//	  }
//	  public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
//		    String jwt = generateTokenFromUsername(userPrincipal.getUsername());
//		    ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
//		    return cookie;
//		  }
//	  public ResponseCookie getCleanJwtCookie() {
//		    ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
//		    return cookie;
//		  }
//	  public String getUserNameFromJwtToken(String token) {
//		    return Jwts.parserBuilder().setSigningKey(key()).build()
//		        .parseClaimsJws(token).getBody().getSubject();
//		  }
//	  private java.security.Key key() {
//		    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
//		  }
//	  public boolean validateJwtToken(String authToken) {
//		    try {
//		      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
//		      return true;
//		    } catch (MalformedJwtException e) {
//		      logger.error("Invalid JWT token: {}", e.getMessage());
//		    } catch (ExpiredJwtException e) {
//		      logger.error("JWT token is expired: {}", e.getMessage());
//		    } catch (UnsupportedJwtException e) {
//		      logger.error("JWT token is unsupported: {}", e.getMessage());
//		    } catch (IllegalArgumentException e) {
//		      logger.error("JWT claims string is empty: {}", e.getMessage());
//		    }
//
//		    return false;
//		  }
//	  public String generateTokenFromUsername(String username) {   
//		    return Jwts.builder()
//		              .setSubject(username)
//		              
//		             
//		              .signWith(key(), SignatureAlgorithm.HS256)
//		              .compact();
//		  }
//		}
//
//
//	
	 