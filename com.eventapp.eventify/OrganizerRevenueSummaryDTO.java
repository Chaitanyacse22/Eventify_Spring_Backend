package com.eventapp.eventity;

public class OrganizerRevenueSummaryDTO {
	private Long organizerId;
    private Double totalRevenue;

    // Constructor
    public OrganizerRevenueSummaryDTO(Long organizerId, Double totalRevenue) {
        this.organizerId = organizerId;
        this.totalRevenue = totalRevenue;
    }

    // Getters and Setters
    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
