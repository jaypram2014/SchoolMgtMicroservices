package com.catalyst.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.studentservice.model.StudentMaster;
import com.catalyst.studentservice.service.StudentService;

@RestController
@RequestMapping("/api/student-service")
public class StudentController {
	@Autowired
	private StudentService studService;
	
	@GetMapping("/student/{id}")
	public StudentMaster getStudentById(@PathVariable Long id){
		
		return studService.getStudentById(id);				
	}
	
	@GetMapping("/students")
	public List<StudentMaster> getAllStudents(){
		
		return studService.getAllStudents();				
	}
	
	@PostMapping("/student")
	public StudentMaster saveStudentData(@RequestBody StudentMaster studentData) {
		
		StudentMaster stud=null;
		try {
			stud = studService.saveStudentData(studentData);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return stud;
		
	}
	
	@PatchMapping("/student/{id}")
	@ResponseStatus (value = HttpStatus.CREATED)
	public StudentMaster updateStudentData(@RequestBody StudentMaster studentData, @PathVariable Long id ) {
		
		StudentMaster stud=null;
		try {
			stud = studService.updateStudentData(studentData, id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return stud;
		
	}

}
