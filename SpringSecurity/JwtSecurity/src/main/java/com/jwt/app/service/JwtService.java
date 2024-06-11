package com.jwt.app.service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.jwt.app.entity.CustomeUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	Logger log = LoggerFactory.getLogger(getClass());	
	public String generateToken(Authentication authentication)
	{
		log.info("=============generate token=============");
		CustomeUserDetails userDetails = (CustomeUserDetails)authentication.getPrincipal();
		
		return Jwts.builder()
			.setSubject(userDetails.getUsername())
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
			.signWith(getSinginKey(), SignatureAlgorithm.HS256)
			.compact();
	}
	
	private <T> T extractClaim(String token , Function<Claims,T> claimresolver) {
		final Claims claim = extractClaims(token);
		return claimresolver.apply(claim);
	}
	
	public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	private Key getSinginKey() {
		
		byte[] key = Decoders.BASE64.decode("aa9a73582baec1b14beb40f977c3105a70808098455005ebb5cb7da07660e088");
		return Keys.hmacShaKeyFor(key);
	}
	
	private Claims extractClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSinginKey()).build().parseClaimsJws(token).getBody();
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		String username = extractUserName(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}
	
	public boolean isTokenExpired(String token) {
		return extractClaim(token, Claims::getExpiration).before(new Date());
	}
}
