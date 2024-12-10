package com.cg.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.Model.Doctor;
import com.cg.Service.DoctorService;
import com.cg.repository.DoctorRepository;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    void testGetAllDoctors() {
        // Arrange
        Doctor doctor1 = new Doctor(1, "manasi", "MBBS");
        Doctor doctor2 = new Doctor(3, "Aditi", "MD");
        Doctor doctor3 = new Doctor(5, "poonam", "MBBS");
        Doctor doctor4 = new Doctor(4, "Vaibhavi", "MD");
        List<Doctor> doctors = Arrays.asList(doctor1, doctor2, doctor3, doctor4);
        when(doctorRepository.findAll()).thenReturn(doctors);

        // Act
        List<Doctor> result = doctorService.getallDoctors();

        // Assert
        assertEquals(4, result.size());
        assertEquals("manasi", result.get(0).getDname());
    }

    @Test
    void testFindById() {
        // Arrange
        Doctor doctor = new Doctor(1, "manasi", "MBBS");
        when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));

        // Act
        Optional<Doctor> result = doctorService.findById(1);

        // Assert
        assertEquals("manasi", result.get().getDname());
    }

    @Test
    void testUpdateDoctor() {
        // Arrange
        Doctor doctor = new Doctor(1, "manasi", "MBBS");
        when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));
        when(doctorRepository.save(doctor)).thenReturn(doctor);

        // Act
        Doctor result = doctorService.updateDoctor(1, doctor);

        // Assert
        assertEquals("manasi", result.getDname());
    }

    @Test
    void testDeleteDoctorById() {
        // Arrange
        when(doctorRepository.existsById(1)).thenReturn(true);

        // Act
        boolean result = doctorService.deleteDoctorById(1);

        // Assert
        assertEquals(true, result);
        verify(doctorRepository, times(1)).deleteById(1);
    }

    @Test
    void testAddDoctor() {
        // Arrange
        Doctor doctor = new Doctor(1, "manasi", "MBBS");
        when(doctorRepository.save(doctor)).thenReturn(doctor);

        // Act
        Doctor result = doctorService.addDoctor(doctor);

        // Assert
        assertEquals("manasi", result.getDname());
    }
}