package com.cg.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Model.Doctor;
import com.cg.repository.DoctorRepository;

@Service
public class DoctorService implements IDoctorService {
	@Autowired
	DoctorRepository doctorrepo;
	
	@Override
	public List<Doctor> getallDoctors() {
		// TODO Auto-generated method stub
		return doctorrepo.findAll();
	}
	@Override
	public Optional<Doctor> findById(int id) {
		// TODO Auto-generated method stub
		return doctorrepo.findById(id);
	}
	@Override
	public Doctor updateDoctor(int id, Doctor doctor) {
	    // Find the existing doctor by id
	    Optional<Doctor> existingDoctor = doctorrepo.findById(id);
	    
	   // if (existingDoctor.isPresent()) {
	        Doctor updatedDoctor = existingDoctor.get();
	        updatedDoctor.setDname(doctor.getDname());
	        updatedDoctor.setQualification(doctor.getQualification());
	        return doctorrepo.save(updatedDoctor);
	    } 
	//else {
	        // Handle the case where the doctor with the given id doesn't exist
	      //  throw new EntityNotFoundException("Doctor not found with id " + id);
	    //}
//	}
	@Override
	public Boolean deleteDoctorById(int id) {
	    if (doctorrepo.existsById(id)) {
	        doctorrepo.deleteById(id);
	        return true;
	    } else {
	        return false; 
	    }
	}
	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorrepo.save(doctor);
	}
	@Override
    public int getCountByDoctor(String dname) {
        return doctorrepo.getCountByDoctor(dname);
    }
	

}
