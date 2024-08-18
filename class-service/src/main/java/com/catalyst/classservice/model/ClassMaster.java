package com.catalyst.classservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "class_master", schema = "sms_class")
//@TableGenerator(name = "teacher_master_SEQ", table = "seq_id_table", schema = "sms", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_VALUE", initialValue = 1, allocationSize = 1)
public class ClassMaster {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "class_id")
    private Long id;

	@Column(name = "class_name")
    private String className;
	
	//@OneToMany(mappedBy = "classMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)	 // mappedBy = "classMaster"
	//List<StudentMaster> students = new ArrayList<StudentMaster>();

	
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

	//@JsonManagedReference
//	public List<StudentMaster> getStudents() {
//		return students;
//	}
//
//	public void setStudents(List<StudentMaster> students) {
//		this.students = students;
//	}	
//	
	
}
