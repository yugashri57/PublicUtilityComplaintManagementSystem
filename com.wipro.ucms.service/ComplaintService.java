package com.wipro.ucms.service;

import java.util.ArrayList;
import com.wipro.ucms.entity.Complaint;
import com.wipro.ucms.entity.ComplaintUpdate;
import com.wipro.ucms.entity.Technician;
import com.wipro.ucms.util.ComplaintNotFoundException;
import com.wipro.ucms.util.InvalidComplaintOperationException;
import com.wipro.ucms.util.TechnicianNotFoundException;

public class ComplaintService {
	private ArrayList<Complaint>complaints;
	private ArrayList<Technician>technicians;
	private ArrayList<ComplaintUpdate> updates;
	
	public ComplaintService(ArrayList<Complaint>complaints, ArrayList<Technician> technicians,ArrayList<ComplaintUpdate> updates) {
		this.complaints=complaints;
		this.technicians=technicians;
		this.updates=updates;
	}
    
	public void registerComplaint(Complaint c){
		complaints.add(c);
		
	}
	public Complaint findComplaint(String complaintId) throws ComplaintNotFoundException{
		for(Complaint c:complaints) {
			if(c.getComplaintId().equals(complaintId)) {
				return c;
			}
		}
		throw new ComplaintNotFoundException("Complaint ID not found"+complaintId);
			
	}
	
	public Technician findTechnician(String technicianId) throws TechnicianNotFoundException{
		for(Technician t:technicians) {
			if(t.getTechnicianId().equals(technicianId)) {
				return t;
			}
		}
		throw new TechnicianNotFoundException("Technician not found"+technicianId);
		
	}
	
	public void assignTechnician(String complaintId,String technicianId) throws ComplaintNotFoundException,TechnicianNotFoundException{
		Complaint complaint=findComplaint(complaintId);
		Technician technician=findTechnician(technicianId);
			
		complaint.assignTechnician(technician);	
		
	}
	public void updateComplaintStatus(String complaintId, String newStatus) throws ComplaintNotFoundException,InvalidComplaintOperationException{
		if(newStatus==null||newStatus.isEmpty()) {
			throw new InvalidComplaintOperationException("Status cannot be empty");
		}
		Complaint complaint=findComplaint(complaintId);
		
		complaint.setStatus(newStatus);
		
		updates.add(new ComplaintUpdate("AUTO",complaintId,"TODAY",newStatus));	
	}
	public void addComplaintUpdate(ComplaintUpdate update)throws ComplaintNotFoundException,InvalidComplaintOperationException{
		if(update==null||update.getNotes()==null||update.getNotes().isEmpty()) {
			throw new InvalidComplaintOperationException("update description cannot be empty");
			
		}
		findComplaint(update.getComplaintId());
		updates.add(update);
		
	}
	public ArrayList<ComplaintUpdate>getComplaintHistory(String complaintId) throws ComplaintNotFoundException{
		findComplaint(complaintId);
		ArrayList<ComplaintUpdate> result=new ArrayList<>();
		for(ComplaintUpdate u : updates) {
			if(u.getComplaintId().equals(complaintId)) {
				result.add(u);
			}
		}
		return result;	
	}
	

	public String generateComplaintSummary(String complaintId) throws ComplaintNotFoundException {
		Complaint c=findComplaint(complaintId);
		return "Complaint id:"+c.getComplaintId()+
				"\nCitizen:"+c.getCitizenName()+
				"\nCategory:"+c.getCategory()+
				"\nStatus:"+c.getStatus()+
				"\nTechnicianId assigned:"+c.getTechnicianId();
		}	
}
