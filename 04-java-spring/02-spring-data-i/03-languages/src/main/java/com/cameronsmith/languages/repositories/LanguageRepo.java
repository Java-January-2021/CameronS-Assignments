package com.cameronsmith.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.languages.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language,Long>{
	List<Language> findAll();
}
