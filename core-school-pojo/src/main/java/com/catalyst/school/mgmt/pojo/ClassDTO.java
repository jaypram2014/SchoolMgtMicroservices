package com.catalyst.school.mgmt.pojo;

import java.io.Serializable;
import java.util.List;




public class ClassDTO implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -6823312689399683996L;


	private Long id;

	
    private String className;
	
    private List<StudentDTO> students;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}

	
	
}
