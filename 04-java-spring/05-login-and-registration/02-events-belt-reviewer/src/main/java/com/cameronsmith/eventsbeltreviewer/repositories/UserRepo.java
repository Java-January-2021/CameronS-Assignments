package com.cameronsmith.eventsbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.eventsbeltreviewer.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findAll();
	boolean existsByEmail(String email);
	User findByEmail(String email);
}
