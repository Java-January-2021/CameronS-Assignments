package com.cameronsmith.queriesandjoins.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.queriesandjoins.repositories.CityRepo;
import com.cameronsmith.queriesandjoins.repositories.CountryRepo;
import com.cameronsmith.queriesandjoins.repositories.LanguageRepo;

@Service
public class ApiService {
	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private LanguageRepo langRepo;
	@Autowired
	private CityRepo cityRepo;
	
}
