package com.eventapp.eventity;

public class RevenueByOrganizerAndEventTypeDT {
	private String organizerId;
    private String eventType;
    private Double totalRevenue;

    // Constructor
    public RevenueByOrganizerAndEventTypeDT(String organizerId, String eventType, Double totalRevenue) {
        this.organizerId = organizerId;
        this.eventType = eventType;
        this.totalRevenue = totalRevenue;
    }

    // Getters and Setters
    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
