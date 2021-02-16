package com.cameronsmith.eventsbeltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
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
	@NotBlank(message="Name Required")
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String eventName;
	@NotBlank(message="Location Required")
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String eventLocation;
	@NotBlank
	private String eventState;
	@NotNull(message="Date Required")
	@Future(message="You Cannot Time Travel.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
    private List<Message> eventMessages;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events", 
        joinColumns = @JoinColumn(name = "event_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersAttending;
	
	public Event() {
		
	}
	public Event(String eventName, String eventLocation, String eventState, Date eventDate) {
		this.eventName = eventName;
		this.eventLocation = eventLocation;
		this.eventState = eventState;
		this.eventDate = eventDate;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEventName() {
		return this.eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventLocation() {
		return this.eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getEventState() {
		return this.eventState;
	}
	public void setEventState(String eventState) {
		this.eventState = eventState;
	}
	public Date getEventDate() {
		return this.eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public List<Message> getEventMessages() {
		return this.eventMessages;
	}
	public void setEventMessages(List<Message> eventMessages) {
		this.eventMessages = eventMessages;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return this.user;
	}
	public List<User> getUsersAttending() {
		return this.usersAttending;
	}
	public void setUsersAttending(List<User> usersAttending) {
		this.usersAttending = usersAttending;
	}
}