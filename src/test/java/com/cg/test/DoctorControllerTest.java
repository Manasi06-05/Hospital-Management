package com.cg.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.Controller.doctorController;
import com.cg.Model.Doctor;
import com.cg.Service.IDoctorService;
import com.cg.exception.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class DoctorControllerTest {

    @Mock
    private IDoctorService doctorService;

    @InjectMocks
    private doctorController doctorcontroller;
    
    private Doctor doctor1;
    
    @BeforeEach
    void setUp() {
        // Initialize the doctor object
    	doctor1 = new Doctor(1, "Manasi", "MBBS");
    }

    @Test
    void testGetAllDoctors() {
        List<Doctor> doctors = Arrays.asList(doctor1);
        when(doctorService.getallDoctors()).thenReturn(doctors);

        List<Doctor> result = doctorcontroller.getAllDoctors();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("Manasi", result.get(0).getDname());
    }

    @Test
    void testAddDoctor() throws ResourceNotFoundException {
        when(doctorService.addDoctor(doctor1)).thenReturn(doctor1);

        // Act
        Doctor result = doctorcontroller.addDoctor(doctor1);

        // Assert
        assertEquals("Manasi", result.getDname());
    }

    @Test
    void testFindById() throws ResourceNotFoundException {
        when(doctorService.findById(1)).thenReturn(Optional.of(doctor1));

        // Act
        Doctor result = doctorcontroller.findById(1);

        // Assert
        assertEquals("Manasi", result.getDname());
    }

//    @Test
//    void testUpdateDoctor() throws ResourceNotFoundException {
//        // Arrange: Updated doctor with new details
//        Doctor updatedDoctor = new Doctor(1, "Manasi Updated", "MD");
//        when(doctorService.updateDoctor(1, updatedDoctor)).thenReturn(updatedDoctor);
//
//        // Act
//        Doctor result = doctorcontroller.updateDoctor(1, updatedDoctor);
//
//        // Assert: Check if the updated name and qualification are returned
//        assertEquals("Manasi Updated", result.getDname());
//        assertEquals("MD", result.getQualification());
//    }

    @Test
    void testDeleteDoctor() throws ResourceNotFoundException {
        // Arrange: Doctor deletion is successful
        when(doctorService.deleteDoctorById(1)).thenReturn(true);

        // Act
        doctorcontroller.deleteDoctor(1);

        // Assert: Verify if delete method was called exactly once
        verify(doctorService, times(1)).deleteDoctorById(1);
    }

//    @Test
//    void testFindById_NotFound() {
//        // Arrange: Doctor is not found
//        when(doctorService.findById(2)).thenReturn(Optional.empty());
//
//        // Act & Assert: Expect a ResourceNotFoundException (update controller to handle)
//        assertThrows(ResourceNotFoundException.class, () -> doctorcontroller.findById(2));
//    }

//    @DeleteMapping(value="/delete/{id}")
//    public void deleteDoctor(@PathVariable int id) throws ResourceNotFoundException {
//        boolean isDeleted = doctorService.deleteDoctorById(id);
//        
//        if (!isDeleted) {
//            String doctorDeletionFailedMessage;
//			// If the deletion fails, throw a ResourceNotFoundException
//            throw new ResourceNotFoundException(String.format(doctorDeletionFailedMessage, id));
//        }
//    }

}
