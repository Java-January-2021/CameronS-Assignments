package com.cameronsmith.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.dojooverflow.models.Answer;

public interface AnswerRepo extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
}
