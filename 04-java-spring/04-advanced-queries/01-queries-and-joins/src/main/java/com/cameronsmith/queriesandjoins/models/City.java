package com.cameronsmith.queriesandjoins.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {
	@Id
	private Integer id;
	private String name;
	private String country_code;
	private String district;
	private Integer population;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	public City() {
		
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry_code() {
		return this.country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getDistrict() {
		return this.district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getPopulation() {
		return this.population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Country getCountry() {
		return this.country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
