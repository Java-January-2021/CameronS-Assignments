package com.cameronsmith.queriesandjoins.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {
	@Id
	private Integer id;
	private String code;
	private String name;
	private String continent;
	private String region;
	private Float surfaceArea;
	private Short indepYear;
	private Integer population;
	private Float lifeExpectancy;
	private Float gnp;
	private Float gnpOld;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private Integer capital;
	private String code2;
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<Language> languages;
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<City> cities;
	public Country() {
		
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return this.continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return this.region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Float getSurfaceArea() {
		return this.surfaceArea;
	}
	public void setSurfaceArea(Float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	public Short getIndepYear() {
		return this.indepYear;
	}
	public void setIndepYear(Short indepYear) {
		this.indepYear = indepYear;
	}
	public Integer getPopulation() {
		return this.population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Float getLifeExpectancy() {
		return this.lifeExpectancy;
	}
	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}
	public Float getGnp() {
		return this.gnp;
	}
	public void setGnp(Float gnp) {
		this.gnp = gnp;
	}
	public Float getGnpOld() {
		return this.gnpOld;
	}
	public void setGnpOld(Float gnpOld) {
		this.gnpOld = gnpOld;
	}
	public String getLocalName() {
		return this.localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getGovernmentForm() {
		return this.governmentForm;
	}
	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}
	public String getHeadOfState() {
		return this.headOfState;
	}
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	public Integer getCapital() {
		return this.capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return this.code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public List<Language> getLanguages() {
		return this.languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	public List<City> getCities() {
		return this.cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
