package com.eventapp.eventity;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name="event")
public class Event {
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String type;
    private Date date;
    private String location;
    private double price;
    private String status;
    @Column(name = "organizer_id")
    private int organizer_id;
    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")  
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")  
    private LocalDateTime updated_at;
    private String image;
//    private String updated_at;
	public Event(Long id, String title, String description, String type, Date date, String location, double price,
			String status, int organizer_id, String created_at, String updated_at, String image) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
		this.date = date;
		this.location = location;
		this.price = price;
		this.status = status;
		this.organizer_id=organizer_id;
		this.image=image;
	}

	public Event() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrganizer_id() {
		return organizer_id;
	}

	public void setOrganizer_id(int organizer_id) {
		this.organizer_id = organizer_id;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
