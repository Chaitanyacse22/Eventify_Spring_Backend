package com.eventapp.eventity;

public class EventRevenueSummaryDTO {
	private Long eventId;
    private Double totalRevenue;

    // Constructor
    public EventRevenueSummaryDTO(Long eventId, Double totalRevenue) {
        this.eventId = eventId;
        this.totalRevenue = totalRevenue;
    }

    // Getters and Setters
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
