package com.catalyst.classservice.feign.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.catalyst.school.mgmt.pojo.StudentDTO;


@FeignClient(name = "student-service", url = "/api/class-service/")
public interface StudentServiceClientIntf {

  @GetMapping("/student/{id}")
  public StudentDTO getStudentById(@PathVariable Long id);

  @GetMapping("/students")
  public List<StudentDTO> getAllStudents();

  @PostMapping("/student")
  public StudentDTO saveStudentData(@RequestBody StudentDTO studentData);

  @PatchMapping("/student/{id}")
  public StudentDTO updateStudentData(@RequestBody StudentDTO studentData, @PathVariable Long id);

}
