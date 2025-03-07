package com.eventapp.eventity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@Autowired
    private EventRepository eventRepository;
	
	@Autowired
    private JavaMailSender javaMailSender;

    public List<Object[]> getTotalRegistrationsPerEvent() {
        return eventRepository.findTotalRegistrationsPerEvent();
    }

    public List<Object[]> getTotalRevenuePerEvent() {
        return eventRepository.findTotalRevenuePerEvent();
    }

    public List<Object[]> getTotalRevenueForAllOrganizers() {
        return eventRepository.findTotalRevenueForAllOrganizers();
    }

    public List<Object[]> getTotalRevenueByOrganizer(Long organizerId) {
        return eventRepository.findTotalRevenueByOrganizer(organizerId);
    }

    public Double getSumPricesByOrganizerAndEventType(Long organizerId, String eventType) {
        return eventRepository.findSumPricesByOrganizerAndEventType(organizerId, eventType);
    }

    public Long getCountRegistrationsByDate(java.sql.Date registrationDate) {
        return eventRepository.countRegistrationsByDate(registrationDate);
    }
    
    //Mail Sending by Event-Organizer Module
    public void sendEmail(String to, String subject, String text) {
    	try {
        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        message.setFrom("swathinayak02@gmail.com"); 
        System.out.println("In the sendEmail()...");
        message.setFrom("swathinayak02@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        System.out.println("Before sending the email...");
        javaMailSender.send(message);
        System.out.println("Message is sent successfully...");
        }
    	catch(MailParseException ex) {
    		System.out.println("MailParseException is : "+ex);
    	}
    	catch (MailAuthenticationException ex) {
    		System.out.println("MailAuthenticationException "+ex);
    	}
    	catch (MailSendException ex) {
    		System.out.println("MailSendException :"+ex);
    	}
    	catch(MailException ex) {
    		System.out.println("MailException : "+ex);
    	} 

    }
}
