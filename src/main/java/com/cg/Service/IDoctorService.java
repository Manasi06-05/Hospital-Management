package com.cg.Service;

import java.util.List;
import java.util.Optional;

import com.cg.Model.Doctor;

public interface IDoctorService {
	List<Doctor>getallDoctors();
	Doctor addDoctor(Doctor doctor);
	Optional<Doctor>findById(int id);
	Doctor updateDoctor(int id,Doctor doctor);
	Boolean deleteDoctorById(int id);
    int getCountByDoctor(String dname);
	
	

}
