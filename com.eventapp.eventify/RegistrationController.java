package com.eventapp.eventity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/events")
public class RegistrationController {
	
	public RegistrationController() {

	}
	
	@Autowired
	RegistrationDAO regDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
    @Autowired
    private EventService eventService;
    
    //This insights is for getting the registration and admin organizers
    
    @GetMapping("/total-registrations-per-event")
    public List<EventRegistrationSummaryDTO> getTotalRegistrationsPerEvent() {
        List<Object[]> results = eventService.getTotalRegistrationsPerEvent();
        List<EventRegistrationSummaryDTO> summaryDTOs = new ArrayList<>();
        for (Object[] result : results) {
            Long eventId = (Long) result[0];
            Long registrationCount = (Long) result[1];
            Double totalRevenue = (Double) result[2];
            summaryDTOs.add(new EventRegistrationSummaryDTO(eventId, registrationCount, totalRevenue));
        }
        return summaryDTOs;
    }

    @GetMapping("/total-revenue-per-event")
    public List<EventRevenueSummaryDTO> getTotalRevenuePerEvent() {
        List<Object[]> results = eventService.getTotalRevenuePerEvent();
        List<EventRevenueSummaryDTO> summaryDTOs = new ArrayList<>();
        for (Object[] result : results) {
            Long eventId = (Long) result[0];
            Double totalRevenue = (Double) result[1];
            summaryDTOs.add(new EventRevenueSummaryDTO(eventId, totalRevenue));
        }
        return summaryDTOs;
    }
    
    @GetMapping("/revenue-by-organizer")
    public List<OrganizerRevenueDTO> getTotalRevenueForAllOrganizers() {
        List<Object[]> results = eventService.getTotalRevenueForAllOrganizers();
        List<OrganizerRevenueDTO> organizerRevenueDTOs = new ArrayList<>();
        for (Object[] result : results) {
//            Long organizerId = (Long) result[0];
        	  Integer organizerId = (Integer) result[0];
              Double totalRevenue = (Double) result[1];
              Long organiseId = Long.valueOf(organizerId);
            organizerRevenueDTOs.add(new OrganizerRevenueDTO(organiseId, totalRevenue));
        }
        return organizerRevenueDTOs;
    }
    
    @GetMapping("/total-revenue-by-organizer/{organizerId}")
    public List<OrganizerRevenueSummaryDTO> getTotalRevenueByOrganizer(@PathVariable Long organizerId) {
        List<Object[]> results = eventService.getTotalRevenueByOrganizer(organizerId);
        List<OrganizerRevenueSummaryDTO> summaryDTOs = new ArrayList<>();
        for (Object[] result : results) {
        	Integer organizerIdInt = (Integer) result[0];
        	Long organizerIdStr = Long.valueOf(organizerIdInt);
            Double totalRevenue = (Double) result[1];
            summaryDTOs.add(new OrganizerRevenueSummaryDTO(organizerIdStr, totalRevenue));
        }
        return summaryDTOs;
    }

    @GetMapping("/sum-prices-by-organizer-and-event-type")
    public List<RevenueByOrganizerAndEventTypeDT>  getSumPricesByOrganizerAndEventType(@RequestParam Long organizerId, @RequestParam String eventType) {
        Double totalRevenue = eventService.getSumPricesByOrganizerAndEventType(organizerId, eventType);
        List<RevenueByOrganizerAndEventTypeDT> revList = new ArrayList<RevenueByOrganizerAndEventTypeDT>();       
        revList.add (new RevenueByOrganizerAndEventTypeDT(organizerId.toString(), eventType, totalRevenue));  
        return revList;
    }

    @GetMapping("/registrations-on-date")
    public List<RegistrationsByDateDTO> getCountRegistrationsByDate(@RequestParam java.sql.Date registrationDate) {
        Long registrationCount = eventService.getCountRegistrationsByDate(registrationDate);
        List<RegistrationsByDateDTO> count = new ArrayList<RegistrationsByDateDTO>();
        count.add(new RegistrationsByDateDTO(registrationCount));
//        return new RegistrationsByDateDTO(registrationCount);
        return count;
    }
    
    //
    
    @GetMapping("/getRegisteredList")
	public List<EventRegistration>getRegisteredList(){
		return regDao.getAllRegisteredList();
	}
    
    @PostMapping("/sendEventUpdates")
    public String sendEventUpdates() {

	    
		 String sql = "SELECT r.email, r.event_id, r.payment_status, e.status AS event_status " +
                 "FROM registration r " +
                 "JOIN event e ON r.event_id = e.id " +
                 "WHERE r.payment_status IN ('Completed', 'Pending')";

    List<Map<String, Object>> registrations = jdbcTemplate.queryForList(sql);
    System.out.println("Registrations : "+registrations);

    for (Map<String, Object> registration : registrations) {    
        String email = (String) registration.get("email");
        int eventId =  (int)registration.get("event_id");
        String paymentStatus = (String) registration.get("payment_status");
        String eventStatus = (String) registration.get("event_status");

        String subject = "";
        String body = "";
  
    
        if ("Cancelled".equals(eventStatus)) {
            subject = "Event Cancelled Notification";
            body = "Dear user,\n\nWe regret to inform you that the event with ID: " + eventId + " has been cancelled. We apologize for the inconvenience.\n\nBest regards,\nEvent Team";
        } else {
            if ("Completed".equals(paymentStatus)) {
                subject = "Event Registration Confirmation";
                body = "Dear user,\n\nYou have successfully registered for the event with ID: " + eventId + ". We look forward to seeing you at the event!\n\nBest regards,\nEvent Team";
            } else if ("Pending".equals(paymentStatus)) {
                subject = "Payment Pending for Event Registration";
                body = "Dear user,\n\nYour payment for the event with ID: " + eventId + " is still pending. Please complete your payment to confirm your registration.\n\nBest regards,\nEvent Team";
            }
        }

        eventService.sendEmail(email, subject, body);
       
     
    }
 
    return "Event update emails sent successfully!";
	}
    
    @PostMapping("/insertdata")
    public String insertEvent(@RequestBody EventRegistration eventObj) {
//    	return "hello";
    	System.out.println(eventObj.getUserId());
    	System.out.println(eventObj.getEventId());
        return regDao.insertEventRecord(eventObj);
    }
    
    @DeleteMapping("/deleteRegister/{id}")
    public String deleteRecord(@PathVariable int id) {
    	return regDao.deleteuserrecord(id);
    }
    
    @PutMapping("/updatefeedback")
    public String updateFeedback(@RequestBody EventRegistration feedback) {
        return regDao.updateEventRecord(feedback);
    }
    
    @GetMapping("/RegisteredEventByUser")
    public List<EventRegistration> getRegistrationsByUserId(@RequestParam("user_id") int userId) {
        return regDao.getRegistrationsByUserId(userId);
    }
    
}
