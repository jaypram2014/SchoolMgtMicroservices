package com.catalyst.school.mgmt.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubjectDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3134826195990453345L;

	private Long subjId;

	private String subjectName;

	List<StudentDTO> students = new ArrayList<StudentDTO>();

	public Long getSubjId() {
		return subjId;
	}

	public void setSubjId(Long subjId) {
		this.subjId = subjId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}

}
