package com.cameronsmith.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
	@Column
	@NotBlank
	@Size(min = 1, max = 20)
	private String name;
	@Column
	@NotBlank
	@Size(min = 1, max = 20)
	private String creator;
	@Column
	@NotBlank
	private String version;
	
	public Language() {
		
	}
	public Language(String name, String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	public Long getId() {
		return this.id;
	}
	public Date getCreatedAt() {
		return this.createdAt;
	}
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	public String getName() {
		return this.name;
	}
	public String getCreator() {
		return this.creator;
	}
	public String getVersion() {
		return this.version;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}
