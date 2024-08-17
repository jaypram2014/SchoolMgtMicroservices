package com.catalyst.classservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.classservice.entity.ClassMaster;
import com.catalyst.classservice.exception.ResourceNotFoundException;
import com.catalyst.classservice.repository.ClassRepo;
import com.catalyst.school.mgmt.pojo.ClassDTO;

@Service
public class ClassService {

  @Autowired
  private ClassRepo classRepo;

  public ClassDTO saveClassData(ClassDTO classDTO) {

    ClassMaster classMaster = new ClassMaster();
    classMaster.setClassName(classDTO.getClassName());

    Optional<ClassMaster> savedClass = Optional.ofNullable(classRepo.save(classMaster));

    ClassDTO newClassDTO = new ClassDTO();
    newClassDTO.setClassName(savedClass.get().getClassName());
    return newClassDTO;

  }

  public ClassMaster getClassById(Long id) {

    return classRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Class don't exists with id " + id));
  }

  public List<ClassMaster> getAllClasses() {

    return classRepo.findAll();
  }
}
