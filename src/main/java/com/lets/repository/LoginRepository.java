package com.lets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lets.model.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long>{
	Optional<LoginModel> findByUsername(String username);
}
