package com.cameronsmith.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	@Size(min = 2, max = 45)
	private String name;
	@Column
	@Size(min = 2, max = 45)
	private String artist;
	@Column
	private int rating;
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	public Song() {
	}
	public Song(String name, String artist, int rating) {
		this.name = name;
		this.artist = artist;
		this.rating = rating;
	}
	public String getName() {
		return this.name;
	}
	public String getArtist() {
		return this.artist;
	}
	public int getRating() {
		return this.rating;
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
	public void setName(String name) {
		this.name = name;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
