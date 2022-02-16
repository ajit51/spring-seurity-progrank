package com.progrank.security.provider;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.progrank.security.auth.SecretKeyAuthToken;
import com.progrank.security.model.UserSecretKey;
import com.progrank.security.repository.UserSecretKeyRepository;

@Component
public class SecretKeyAuthProvider implements AuthenticationProvider{
	
	@Autowired
	UserSecretKeyRepository keyRepository;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		Optional<UserSecretKey> user = keyRepository.findByusername(auth.getName());
		if(user.isPresent()) {
			return new SecretKeyAuthToken(auth.getName(), 
					auth.getCredentials(), 
					Arrays.asList(() -> "read")); 
		}
		throw new BadCredentialsException("Failed secret-key Authentication !!");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return SecretKeyAuthToken.class.equals(authentication);
	}

}
