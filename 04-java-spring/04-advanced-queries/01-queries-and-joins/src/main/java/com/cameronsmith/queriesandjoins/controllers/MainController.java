package com.cameronsmith.queriesandjoins.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cameronsmith.queriesandjoins.services.ApiService;

@RestController
public class MainController {
	@Autowired
	private ApiService apiService;
	
	@GetMapping("/allNames")
	public String findAllTheCountriesNames() {
		List<String> allCountryNames = this.apiService.getAllCountryNames();
		return "allCountriesNames:"+allCountryNames;
	}
	@GetMapping("/l/{language}")
	public String countriesByLanguage(@PathVariable("language")String input) {
		List <String> allCountriesSpeakingSlovene = this.apiService.getCountriesByLang(input);
		return input+" speaking countries: "+allCountriesSpeakingSlovene;
	}
	@GetMapping("/count")
	public List<String> countAllCountriesCities() {
		List<String> thisList = this.apiService.countCitiesInCountries();
		return thisList;
	}
	@GetMapping("/{country}/{popFloor}")
	public String largeCities(@PathVariable("country")String country,@PathVariable("popFloor")Integer popFloor) {
		List<String> thisList = this.apiService.getLargeCities(country, popFloor);
		return country+" cities with population over "+popFloor+": "+thisList;
	}
}
