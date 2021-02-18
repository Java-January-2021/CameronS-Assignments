package com.cameronsmith.queriesandjoins.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class Language {
	@Id
	private Integer id;
	private String countryCode;
	private String language;
	private String isOfficial;
	private Float percentage;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	public Language() {
		super();
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryCode() {
		return this.countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getIsOfficial() {
		return this.isOfficial;
	}
	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}
	public Float getPercentage() {
		return this.percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	public Country getCountry() {
		return this.country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
