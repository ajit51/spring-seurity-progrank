package com.progrank.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progrank.security.model.User;
import com.progrank.security.model.UserSecretKey;

public interface UserSecretKeyRepository extends JpaRepository<UserSecretKey, Integer> {
	
	Optional<UserSecretKey> findByusername(String username);

}
