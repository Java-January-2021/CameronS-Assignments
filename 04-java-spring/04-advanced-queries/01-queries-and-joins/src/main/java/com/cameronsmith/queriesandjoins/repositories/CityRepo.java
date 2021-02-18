package com.cameronsmith.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.queriesandjoins.models.City;

@Repository
public interface CityRepo extends CrudRepository<City, Long>{
	List<City> findAll();

}
