package com.cameronsmith.show.bookmodels;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column
 @NotBlank(message="Title Required")
 @Size(min = 5, max = 200, message = "Title minimum of 5 characters.")
 private String title;
 @Column
 @NotBlank(message="Desc Required")
 @Size(min = 5, max = 200, message = "Desc minimum of 5 characters.")
 private String description;
 @Column
 @NotBlank(message="Author Required")
 @Size(min = 3, max = 40)
 private String author;
 @Column
 @NotBlank(message="Language Required")
 @Size(min = 3, max = 40)
 private String language;
 @Column
 @Min(100)
 @NotNull
 private int numberOfPages;
 @Column(updatable=false)
 @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
 private Date createdAt;
 @Column
 @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
 private Date updatedAt;
 
public Book() {
	
}

public Book(String title, String description,
		 String author, String language, int numberOfPages) {
	this.title = title;
	this.description = description;
	this.author = author;
	this.language = language;
	this.numberOfPages = numberOfPages;
}

public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return this.title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return this.description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getAuthor() {
	return this.author;
}

public void setLanguage(String language) {
	this.language = language;
}

public String getLanguage() {
	return this.language;
}

public void setAuthor(String author) {
	this.author = author;
}

public int getNumberOfPages() {
	return this.numberOfPages;
}

public void setNumberOfPages(int numberOfPages) {
	this.numberOfPages = numberOfPages;
}

public Date getCreatedAt() {
	return this.createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return this.updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}
@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}
 
}