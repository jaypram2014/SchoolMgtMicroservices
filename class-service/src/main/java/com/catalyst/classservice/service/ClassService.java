package com.catalyst.classservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.classservice.entity.ClassMaster;
import com.catalyst.classservice.exception.ResourceNotFoundException;
import com.catalyst.classservice.feign.client.StudentServiceClientIntf;
import com.catalyst.classservice.repository.ClassRepo;
import com.catalyst.school.mgmt.pojo.ClassDTO;
import com.catalyst.school.mgmt.pojo.StudentDTO;

@Service
public class ClassService {

  @Autowired
  private ClassRepo classRepo;

  @Autowired
  private StudentServiceClientIntf studentServiceClient;

  public ClassDTO saveClassData(ClassDTO classDTO) {

    ClassMaster classMaster = new ClassMaster();
    classMaster.setClassName(classDTO.getClassName());

    Optional<ClassMaster> savedClass = Optional.ofNullable(classRepo.save(classMaster));

    ClassDTO newClassDTO = new ClassDTO();
    newClassDTO.setClassName(savedClass.get().getClassName());
    newClassDTO.setStudents(getCreatedStudents(classDTO.getStudents()));
    return newClassDTO;

  }

  private List<StudentDTO> getCreatedStudents(List<StudentDTO> list) {
    List<StudentDTO> sudList = new ArrayList<>();
    list.forEach(t->{
      StudentDTO studentData = createStudentData(t);
      sudList.add(studentData);
    });
   
    return sudList;
  }

  public ClassMaster getClassById(Long id) {

    return classRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Class don't exists with id " + id));
  }

  public List<ClassMaster> getAllClasses() {

    return classRepo.findAll();
  }

  public StudentDTO createStudentData(StudentDTO studentDTO) {

    return studentServiceClient.saveStudentData(studentDTO);
  }

}
