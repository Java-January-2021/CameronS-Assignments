package com.cameronsmith.driverslicense.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name="licenses")
public class License {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	@Column
	private Long number;
	@Column
	private Date expirationDate;
	@Column
	private String state;
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
	public License() {
		
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
	public Long getNumber() {
		return this.number;
	}
	public Date getExpirationDate() {
		return this.expirationDate;
	}
	public String getState() {
		return this.state;
	}
	public Person getPerson() {
		return this.person;
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
	public void setNumber(Long number) {
		this.number = number;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
