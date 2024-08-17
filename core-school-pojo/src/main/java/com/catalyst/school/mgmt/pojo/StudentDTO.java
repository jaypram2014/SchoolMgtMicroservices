package com.catalyst.school.mgmt.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class StudentDTO implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5783564183091465562L;


	private Long id;

	private Long classId;
	
    private String firstName;
	

    private String lastName;

    private String guardianName;

    private String bloodGroup;
    
    private List<SubjectDTO> subjects = new ArrayList<>();

	public List<SubjectDTO> getSubjects() {
		return subjects;
	}

	
	public void setSubjects(List<SubjectDTO> subjects) {
		this.subjects = subjects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}



	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public Long getClassId() {
		return classId;
	}


	public void setClassId(Long classId) {
		this.classId = classId;
	}



}
