package com.eventapp.eventity;

public class EventRegistrationSummaryDTO {
	private Long eventId;
    private Long registrationCount;
    private Double totalRevenue;

    // Constructor
    public EventRegistrationSummaryDTO(Long eventId, Long registrationCount, Double totalRevenue) {
        this.eventId = eventId;
        this.registrationCount = registrationCount;
        this.totalRevenue = totalRevenue;
    }

    // Getters and Setters
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getRegistrationCount() {
        return registrationCount;
    }

    public void setRegistrationCount(Long registrationCount) {
        this.registrationCount = registrationCount;
    }

	public Double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

}
