package com.cameronsmith.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.dojosandninjas.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo,Long>{
	List<Dojo> findAll();

}
