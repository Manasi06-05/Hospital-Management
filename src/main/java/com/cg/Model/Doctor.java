package com.cg.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor_detail")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	@Column
	private String dname;
	@Column
	private String qualification;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int did, String name, String qualification) {
		super();
		this.did = did;
		this.dname = name;
		this.qualification = qualification;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	 public String getDname() {
	        return dname;
	    }

	    public void setDname(String dname) {
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
		return "Doctor [did=" + did + ", name=" + dname + ", qualification=" + qualification + "]";
	}




 
}

 
