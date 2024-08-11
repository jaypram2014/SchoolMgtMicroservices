package com.catalyst.studentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalyst.studentservice.model.StudentMaster;

public interface StudentRepo extends JpaRepository<StudentMaster, Long>{

	Optional<StudentMaster> findByFirstNameAndLastName(String firstName, String lastName);
    // Nothing here to override
	
	
}
