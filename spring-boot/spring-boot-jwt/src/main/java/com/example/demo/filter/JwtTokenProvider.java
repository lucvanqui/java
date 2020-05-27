package com.example.demo.filter;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	private static final long validity = 360000;
	private static final String secretString = "test-demo";
	
	@Autowired
	private UserDetailsService userDetailsService;

	public String createToken(String userName, List<String> roles) {
		 Claims claims = Jwts.claims().setSubject(userName);
	     claims.put("roles", roles);
	     Date now = new Date();
	     Date valid = new Date(now.getTime() + validity);
	     String encodedSecret = Base64.getEncoder().encodeToString(secretString.getBytes());
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(valid)
				.signWith(SignatureAlgorithm.HS256, encodedSecret)
				.compact();
				
	}
	
	public boolean validateToken(String token) throws Exception {
		try {
			String encodedSecret = Base64.getEncoder().encodeToString(secretString.getBytes());
			Jws<Claims> claims = Jwts.parser().setSigningKey(encodedSecret).parseClaimsJws(token);
			if (claims.getBody().getExpiration().before(new Date())) {
				return false;
			}
			return true;
		}
		catch(JwtException | IllegalArgumentException e){
			throw new JwtException("Invalid token or token has expired");
		}
	}
	
	public String getUsername(String token) {
		String encodedSecret = Base64.getEncoder().encodeToString(secretString.getBytes());
		Jws<Claims> claims = Jwts.parser().setSigningKey(encodedSecret).parseClaimsJws(token);
		return claims.getBody().getSubject();
	}

	public String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

	public Authentication getAuthentication(String token) {
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
}
