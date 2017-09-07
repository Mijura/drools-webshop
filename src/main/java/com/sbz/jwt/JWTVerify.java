package com.sbz.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;


public class JWTVerify {

	@SuppressWarnings("unused")
	public static boolean verify(String token, String role){
		if(token==null)
			return false;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("sbz");
		    JWTVerifier verifier = JWT.require(algorithm)
		    	.withClaim("role", role)
		        .build(); //Reusable verifier instance
		    
			DecodedJWT jwt = verifier.verify(token);
		    return true;
		} catch (Exception exception){
			return false;
		} 
	}

	public static String verifyAndGetUsername(String token, String role){
		if(token==null)
			return null;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("sbz");
		    JWTVerifier verifier = JWT.require(algorithm)
		    	.withClaim("role", role)
		        .build(); //Reusable verifier instance
		    
			DecodedJWT jwt = verifier.verify(token);
		    return jwt.getClaim("username").asString();
		} catch (Exception exception){
			return null;
		} 
	}
	
	

}
