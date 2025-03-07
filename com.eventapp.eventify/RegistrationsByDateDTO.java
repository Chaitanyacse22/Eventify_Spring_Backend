package com.eventapp.eventity;

public class RegistrationsByDateDTO {
	private Long registrationCount;

    // Constructor
    public RegistrationsByDateDTO(Long registrationCount) {
        this.registrationCount = registrationCount;
    }

    // Getters and Setters
    public Long getRegistrationCount() {
        return registrationCount;
    }

    public void setRegistrationCount(Long registrationCount) {
        this.registrationCount = registrationCount;
    }
}
