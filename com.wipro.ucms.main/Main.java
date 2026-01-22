package com.wipro.ucms.main;
import java.util.ArrayList;
import com.wipro.ucms.entity.*;
import com.wipro.ucms.service.ComplaintService;

public class Main {
 public static void main(String[] args) {
	 
 ArrayList<Complaint> complaints = new ArrayList<>();
 complaints.add(new Complaint("CMP001", "Ravi Kumar", "Electricity", "Power outage in street","OPEN", null));
 
 ArrayList<Technician> technicians = new ArrayList<>();
 technicians.add(new Technician("T001", "Manoj R", "Electricity"));
 
 ArrayList<ComplaintUpdate> updates = new ArrayList<>();
 ComplaintService service = new ComplaintService(complaints, technicians, updates);
 try {
 
 service.assignTechnician("CMP001", "T001");
 
 service.addComplaintUpdate(new ComplaintUpdate("U001", "CMP001", "2025-08-12","Technician inspected transformer"));
 
 service.updateComplaintStatus("CMP001", "RESOLVED");
 
 System.out.println("--- Complaint Summary ---");
 System.out.println(service.generateComplaintSummary("CMP001"));
 } catch (Exception ex) {
    System.out.println(ex);
 }
 }
}
