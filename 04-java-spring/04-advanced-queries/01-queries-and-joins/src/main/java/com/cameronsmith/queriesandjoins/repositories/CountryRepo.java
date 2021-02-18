package com.cameronsmith.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.queriesandjoins.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long>{
	List<Country> findAll();
}
