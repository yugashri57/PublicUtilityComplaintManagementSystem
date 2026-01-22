package com.wipro.ucms.entity;

public class Technician {
	private String technicianId;
	private String name;
	private String department;
	
	public Technician(String technicianId,String name,String department) {
		this.technicianId=technicianId;
		this.name=name;
		this.department=department;
	}
	public String getTechnicianId() {
		return technicianId;
	}
	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
