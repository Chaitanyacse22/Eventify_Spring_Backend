package com.eventapp.eventity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAO {
	@Autowired
	EventRepository evenRepo;
	public List<Event> getAllEvents(){
		return evenRepo.findAll();
	}
	public String insertEventRecord(Event evenObj) {
		evenRepo.save(evenObj);
		return "Record Inserted Successfully";
	}
	public String updateEventData(Event evenObj) {
		evenRepo.save(evenObj);
		return "Given record is updated";
	}
	public String deleteEventRecord(Long evenid) {
		evenRepo.deleteById(evenid);
		return "Given record is deleted";
	}
	
}
