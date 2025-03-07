package com.eventapp.eventity;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name="registration")
public class EventRegistration {
	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  
 
	@Column(name = "user_id")   
//	private int userId;
	private int userId;
 
	@Column(name = "event_id")   
	private int event_id;
 
	@Column(name = "email") 
	private String email;
 
	@Column(name = "registration_date")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") // Add this annotation to specify the format 
	private Date registration_date;
 
	@Column(name = "payment_status") 
	private String payment_status;
	
	@Column(name = "confirm") 

	private Boolean confirm = false; 

	@Column(name = "dispute") 

	private String dispute; 

	@Column(name = "feedback") 

	private String feedback;
	
	private int rating;
	
	
	public EventRegistration() {
		super();
	}

	public EventRegistration(int id, int userId, int event_id, String email, Date registration_date,
			String payment_status, Boolean confirm, String dispute, String feedback, int rating) {
		super();
		this.id = id;
		this.userId = userId;
		this.event_id = event_id;
		this.email = email;
		this.registration_date = registration_date;
		this.payment_status = payment_status;
		this.confirm = confirm; 
		this.dispute = dispute;
		this.feedback = feedback;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEventId() {
		return event_id;
	}

	public void setEventId(int event_id) {
		this.event_id = event_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public Boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(Boolean confirm) {
		this.confirm = confirm;
	}

	public String getDispute() {
		return dispute;
	}

	public void setDispute(String dispute) {
		this.dispute = dispute;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
