package com.eventapp.eventity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDAO {
	
	@Autowired
	EventRegistrationRepository regRepo;
	
	@Autowired
	 EventRepository eventRepo;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<EventRegistration> getAllRegisteredList(){
		return regRepo.findAll();
	}
	
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}
	
	public String insertEventRecord(EventRegistration eventObj) {
		regRepo.save(eventObj);
	    return "Record Inserted in the DB Successfully";
	}
	
	public String deleteuserrecord(int id) {
		regRepo.deleteById(id);
		  return "record is delete successfully";
	  }

	
	public String updateEventRecord(EventRegistration eventRegistration) {
		regRepo.save(eventRegistration);
		return "Record updated in the DB Successfully";	
	}
	
	public List<EventRegistration> getRegistrationsByUserId(int userId) {
        // Query registered events for a specific user
        return regRepo.findByUserId(userId);
    }
}
