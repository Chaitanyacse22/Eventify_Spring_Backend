package com.eventapp.eventity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EventController {
	
	@Autowired
	EventDAO evenDao;
	
	@GetMapping("/getEvents")
	public List<Event>getEvents(){
		return evenDao.getAllEvents();
	}
	@PostMapping("/insertEvent")
	public String insertEvent(@RequestBody Event evenObj) {
			return evenDao.insertEventRecord(evenObj);
	}
	@PutMapping("/updateEvent")
	public String updateEvent(@RequestBody Event evenObj) {
		return evenDao.updateEventData(evenObj);
	}
	@DeleteMapping("/deleteEvent/{id}")
	public String deleteEvent(@PathVariable Long id) {
		return evenDao.deleteEventRecord(id);
	}

}
