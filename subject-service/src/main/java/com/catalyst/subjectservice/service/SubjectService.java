package com.catalyst.subjectservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.subjectservice.exception.ResourceNotFoundException;
import com.catalyst.subjectservice.model.SubjectEnum;
import com.catalyst.subjectservice.model.SubjectMaster;
import com.catalyst.subjectservice.repository.SubjectRepo;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepo subjectRepo;
	
	// find By ID
	public SubjectMaster getSubject(Long id) {
		SubjectMaster subject = null;
		Optional<SubjectMaster> fetchedSubject = subjectRepo.findById(id);
		if(fetchedSubject.isPresent()) {
			subject = fetchedSubject.get();
		}
		
		return subject;
	}

	// find ALL
	public List<SubjectMaster> getAllSubjects() {

		return subjectRepo.findAll();
	}
	
	// find By Subject Name
	public SubjectMaster getSubjectByName(String subjectName) {
		SubjectMaster subject = null;
		Optional<SubjectMaster> fetchedSubject = subjectRepo.findBySubjectName(subjectName);
		if(fetchedSubject.isPresent()) {
			subject = fetchedSubject.get();
		}
		
		return subject;
	}

	// CREATE NEW SUBJECT
	public SubjectMaster saveSubjectData(SubjectMaster subjectData) {

		SubjectMaster subject = null;
//		try {
			SubjectMaster subjectNew = new SubjectMaster();
			if(SubjectEnum.valueOf(subjectData.getSubjectName())!=null) {
				
				// Call FindyByName to check if the subject name exists then set the same subject over here else save new object
				Optional<SubjectMaster> existingSubject = subjectRepo.findBySubjectName(subjectData.getSubjectName());
				if(!existingSubject.isPresent()) {
				   subjectNew.setSubjectName(subjectData.getSubjectName());
				   subject = subjectRepo.save(subjectData);
				}else {
					throw new ResourceNotFoundException("Subject could not be saved :" + subjectData.getSubjectName()+", as this is already present.");
				}
			}else {
				throw new ResourceNotFoundException("Subject could not be saved :" + subjectData.getSubjectName()+", as this is invalid subject.");
			}

//		} catch (Exception e) {			
//			throw new ResourceNotFoundException("Subject could not be saved :" + subjectData.getSubjectName());
//		
//		}

		return subject;

	}
	
	// UPDATE EXISTING SUBJECT
	public SubjectMaster updateSubjectData(SubjectMaster subjectData, Long id) {
		SubjectMaster subject = null;
		try {
			Optional<SubjectMaster> existingSubject = subjectRepo.findById(id);
			
			if(existingSubject.isPresent()) {
				subject = existingSubject.get();
				if(SubjectEnum.valueOf(subjectData.getSubjectName())!=null) {
					subject.setSubjectName(subjectData.getSubjectName());
					subject = subjectRepo.save(subjectData);
				}else {
					System.out.println("Please enter proper subject name");
				}
				
				
			}
		
			
		} catch (Exception e) {			
			throw new ResourceNotFoundException("Subject not found for ID :: " + id);
		}
		
		return subject;
	}

}
