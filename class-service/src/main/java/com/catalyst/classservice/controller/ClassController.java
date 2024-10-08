package com.catalyst.classservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.classservice.model.ClassMaster;
import com.catalyst.classservice.service.ClassService;

@RestController
@RequestMapping("/api/class-service")
public class ClassController {
	@Autowired
	private ClassService classService;

	@GetMapping("/classes")
	public List<ClassMaster> getAllClasses() {

		return classService.getAllClasses();
	}

	@GetMapping("/classes/{id}")
	public ClassMaster getClassById(@PathVariable Long id) {

		return classService.getClassById(id);
	}

	@PostMapping(value="/class", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE}, headers = "content-type=application/json")
	@ResponseStatus(value = HttpStatus.CREATED)		
	public ClassMaster saveclassData(@RequestBody ClassMaster classData) {

		ClassMaster stud = null;
		try {
			stud = classService.saveClassData(classData);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return stud;

	}

	@PutMapping("/class/{id}")
	//@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<ClassMaster> updateclassData(@RequestBody ClassMaster classData, @PathVariable Long id) {

		// ClassMaster cls=null; 

		// pipeline processing / waterflow
		return Optional.ofNullable(classService.updateClassData(classData, id)).map(ResponseEntity::ok)
				.orElse(ResponseEntity.badRequest().build());

		
		
		//// return cls;

	}

}
