package com.catalyst.classservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalyst.classservice.model.ClassMaster;

public interface ClassRepo extends JpaRepository<ClassMaster, Long>{

	public ClassMaster findByClassName(String className);
    // Nothing here to override
	
	
}
