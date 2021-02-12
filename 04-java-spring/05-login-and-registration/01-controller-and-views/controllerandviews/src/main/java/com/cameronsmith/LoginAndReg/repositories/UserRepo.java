package com.cameronsmith.LoginAndReg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.LoginAndReg.models.User;

public interface UserRepo extends CrudRepository<User, Long>{
	List<User> findAll();
	boolean existsByEmail(String email);
	User findByEmail(String email);
}
