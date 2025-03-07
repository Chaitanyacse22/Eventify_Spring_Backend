package com.eventapp.eventity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRegistrationRepository  extends JpaRepository<EventRegistration, Integer>{
	List<EventRegistration> findByUserId(int userId);
}
