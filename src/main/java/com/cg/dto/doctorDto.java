package com.cg.dto;

import com.cg.Model.Doctor;

public class doctorDto {
	private int did;
	private String dname;
	private String qualification;
	public doctorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public doctorDto(int did, String name, String qualification) {
		super();
		this.did = did;
		this.dname = dname;
		this.qualification = qualification;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDName() {
		return dname;
	}
	public void setDName(String dname) {
		this.dname = dname;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "doctorDto [did=" + did + ", dname=" + dname + ", qualification=" + qualification + "]";
	}
	
	public static doctorDto fromEntity(Doctor doctor) {
    	return new doctorDto(doctor.getDid(),doctor.getDname(),doctor.getQualification());
	}
	
	public  Doctor toEntity() {
		return new Doctor(this.did,this.dname,this.qualification);
	
	}
	
	

}
