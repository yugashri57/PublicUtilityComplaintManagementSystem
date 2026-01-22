package com.wipro.ucms.entity;

public class ComplaintUpdate {
	   private String updateId;
	   private String complaintId;
	   private String date;
	   private String notes;
public ComplaintUpdate(String updateId,String complaintId,String date,String notes){
		  this.updateId=updateId;
		  this.complaintId=complaintId;
		  this.date=date;
		  this.notes=notes;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}


