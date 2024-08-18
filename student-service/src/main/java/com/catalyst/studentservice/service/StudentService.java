package com.catalyst.studentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.school.mgmt.pojo.StudentDTO;
import com.catalyst.studentservice.model.StudentMaster;
import com.catalyst.studentservice.repository.StudentRepo;


@Service
public class StudentService {

	@Autowired
	private StudentRepo studRepo;
	
	// find By ID
    /*
     * public StudentDTO getStudentById(Long id) { StudentDTO student = null; Optional<StudentDTO>
     * existingStudent = studRepo.findById(id); if(existingStudent.isPresent()) { student =
     * existingStudent.get(); }
     * 
     * return student; }
     * 
     * // find All public List<StudentDTO> getAllStudents() {
     * 
     * return studRepo.findAll(); }
     */

	// CREATE A STUDENT
	public StudentDTO saveStudentData(StudentDTO studentData) {

		StudentMaster stud = new StudentMaster();
		stud.setFirstName(studentData.getFirstName());
		stud.setBloodGroup(studentData.getBloodGroup());
		StudentDTO newStudentDTO = new StudentDTO();
		try {
		  StudentMaster newStudent=studRepo.save(stud);
		  newStudentDTO.setFirstName(newStudent.getFirstName());
		} catch (Exception e) {			
			e.printStackTrace();
		}

		return newStudentDTO;

	}
	
	// UPDATE EXISTING STUDENT
    /*
     * public StudentDTO updateStudentData(StudentDTO studentData, Long id) { StudentDTO stud =
     * null; try { Optional<StudentDTO> existingStudent = studRepo.findById(id);
     * 
     * if(existingStudent.isPresent()) { stud = existingStudent.get();
     * stud.setFirstName(studentData.getFirstName()); stud.setLastName(studentData.getLastName());
     * 
     * studRepo.save(stud); }
     * 
     * } catch (Exception e) { e.printStackTrace(); }
     * 
     * return stud; }
     */

}
