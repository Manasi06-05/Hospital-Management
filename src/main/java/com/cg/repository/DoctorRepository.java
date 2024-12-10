package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.Model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	Optional<Doctor> findById(int id);
	@Query("SELECT COUNT(d) FROM Doctor d WHERE d.dname = :name")
	int getCountByDoctor(@Param("name") String name);
}
