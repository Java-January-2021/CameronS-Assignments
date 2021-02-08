package com.cameronsmith.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.dojooverflow.models.Question;

public interface QuestionRepo extends CrudRepository<Question, Long>{
	List<Question> findAll();
}
