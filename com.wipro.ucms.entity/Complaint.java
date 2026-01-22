package com.wipro.ucms.entity;

public class Complaint {
	private String complaintId;
	private String citizenName;
	private String category;
	private String description;
	private String status;
	private String technicianId;
	
	public  Complaint(String complaintId, String citizenName, String category,String description, String status, String technicianId) {
		this.complaintId=complaintId;
		this.citizenName=citizenName;
		this.category=category;
		this.description=description;
		this.status=status;
		this.technicianId=technicianId;	
	}
	public String getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}
	public String getCitizenName() {
		return citizenName;
	}
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTechnicianId() {
		return technicianId;
	}
	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}
	public void assignTechnician(Technician technician) {
		this.technicianId= technician.getTechnicianId();	
	}
}
