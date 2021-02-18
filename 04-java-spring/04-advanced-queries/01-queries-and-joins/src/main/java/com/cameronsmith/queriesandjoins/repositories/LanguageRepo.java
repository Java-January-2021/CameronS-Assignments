package com.cameronsmith.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.queriesandjoins.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long>{
	List<Language> findAll();

}
