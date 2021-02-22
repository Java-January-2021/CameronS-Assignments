package com.cameronsmith.queriesandjoins.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.queriesandjoins.models.City;
import com.cameronsmith.queriesandjoins.models.Country;
import com.cameronsmith.queriesandjoins.models.Language;
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
	//Country
		//Create - Update
		//Read by ID-All
		public List<Country> getAllCountry(){
			return this.countryRepo.findAllCountries();
		}
		public Country getCountryById(Long id) {
			return this.countryRepo.findById(id).orElse(null);
		}
		public List<String> getAllCountryNames() {
			return this.countryRepo.findAllCountryNames();
		}
		public List<String> getCountriesByLang(String search){
			return this.countryRepo.getCountryByLang(search);
		}
		public List<String> countCitiesInCountries() {
			return this.countryRepo.CountCitiesInCountries();
		}
		public List<String> getLargeCities(String country, Integer popFloor){
			return this.countryRepo.largeCities(country, popFloor);
		}
	//Language
		//Read by ID-All
		public List<Language> getAllLanguage(){
			return this.langRepo.findAll();
		}
		public Language getLanguageById(Long id) {
			return this.langRepo.findById(id).orElse(null);
		}
	//City
		//Read by ID-All
		public List<City> getAllCity(){
			return this.cityRepo.findAll();
		}
		public City getCityById(Long id) {
			return this.cityRepo.findById(id).orElse(null);
		}

}
