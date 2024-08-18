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
import com.catalyst.school.mgmt.pojo.StudentDTO;
import com.catalyst.studentservice.service.StudentService;

@RestController
@RequestMapping("/api/student-service")
public class StudentController {
	@Autowired
	private StudentService studService;
	
    /*
     * @GetMapping("/student/{id}") public StudentDTO getStudentById(@PathVariable Long id){
     * 
     * return studService.getStudentById(id); }
     * 
     * @GetMapping("/students") public List<StudentDTO> getAllStudents(){
     * 
     * //return studService.getAllStudents(); }
     */
	
	@PostMapping("/student")
	public StudentDTO saveStudentData(@RequestBody StudentDTO studentData) {
		
		StudentDTO stud=null;
		try {
			stud = studService.saveStudentData(studentData);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return stud;
		
	}
	
	@PatchMapping("/student/{id}")
	@ResponseStatus (value = HttpStatus.CREATED)
	public StudentDTO updateStudentData(@RequestBody StudentDTO studentData, @PathVariable Long id ) {
		
		StudentDTO stud=null;
		try {
		//	stud = studService.updateStudentData(studentData, id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return stud;
		
	}

}
