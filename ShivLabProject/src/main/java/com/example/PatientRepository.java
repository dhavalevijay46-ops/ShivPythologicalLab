package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Patient findByNameAndAgeAndGenderAndPhoneAndStatus(
		    String name,
		    int age,
		    String gender,
		    String phone,
		    String Type,
		    String status
		);
}