package com.catalyst.subjectservice.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject_master", schema = "sms_subject")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SubjectMaster {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "subject_id")
    private Long subjId;

	@Column(name = "subject_name")
    private String subjectName;
	
	
	@ManyToMany(fetch = FetchType.LAZY)		
	List<StudentMaster> students = new ArrayList<StudentMaster>();
			

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


//	@JsonInclude(value =Include.NON_NULL)
	@JsonIgnoreProperties
	public List<StudentMaster> getStudents() {
		return students;
	}
//
	public void setStudents(List<StudentMaster> students) {
		this.students = students;
	}
	
	

}
