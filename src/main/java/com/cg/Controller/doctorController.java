package com.cg.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cg.Model.Doctor;
import com.cg.Service.IDoctorService;
import com.cg.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class doctorController {

    @Autowired
    private IDoctorService docservice;
    
 // Logger for the controller
    private static final Logger logger = LoggerFactory.getLogger(doctorController.class);


    // Inject error messages from properties file
    @Value("${error.doctorNotFound}")
    private String doctorNotFoundMessage;

    @Value("${error.doctorDeletionFailed}")
    private String doctorDeletionFailedMessage;

    @Value("${error.doctorAlreadyExistsMessage}")
    private String doctorAlreadyExistsMessage;

    
    // Get all doctors
    @GetMapping("/doclist")
    public List<Doctor> getAllDoctors() {
        logger.info("Fetching all doctors");
        return docservice.getallDoctors();
    }

    // Add new doctor
    @PostMapping(value = "/adddoctor", produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor addDoctor(@RequestBody Doctor doctor) throws ResourceNotFoundException {
        logger.info("Attempting to add a new doctor");
        
        Optional<Doctor> existingDoctor = docservice.findById(doctor.getDid());
        if (existingDoctor.isPresent()) {
            throw new ResourceNotFoundException(String.format(doctorAlreadyExistsMessage, doctor.getDid()));
        }

        return docservice.addDoctor(doctor);
    }

    // Find by ID
    @GetMapping("/find/{id}")
    public Doctor findById(@PathVariable int id) throws ResourceNotFoundException {
        Optional<Doctor> doctor = docservice.findById(id);
        return doctor.orElseThrow(() -> new ResourceNotFoundException(String.format(doctorNotFoundMessage, id)));
    }

    // Update doctor
    @PutMapping(value = "/update/{id}")
    public Doctor updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) throws ResourceNotFoundException {
        Optional<Doctor> existingDoctor = docservice.findById(id);
        if (!existingDoctor.isPresent()) {
            throw new ResourceNotFoundException(String.format(doctorNotFoundMessage, id));
        }

        return docservice.updateDoctor(id, doctor);
    }

    // Delete doctor
    @DeleteMapping(value = "/delete/{id}")
    public void deleteDoctor(@PathVariable int id) throws ResourceNotFoundException {
        boolean isDeleted = docservice.deleteDoctorById(id);
        if (!isDeleted) {
            throw new ResourceNotFoundException(String.format(doctorDeletionFailedMessage, id));
        }
    }

    // Display all doctors with logging
    @RequestMapping("/log/alldoctors")
    public List<Doctor> displayDoctorsWithLogging() {
        logger.info("Doctor list is going to display");
        List<Doctor> listDoctors = docservice.getallDoctors();
        logger.info("Doctor list displayed");
        logger.debug("Doctors: {}", listDoctors);

        return listDoctors;
    }
    
 // Custom Query
    @GetMapping("/Count")
    public int getCount(@RequestParam String dname) {
        return docservice.getCountByDoctor(dname);
    }
}
