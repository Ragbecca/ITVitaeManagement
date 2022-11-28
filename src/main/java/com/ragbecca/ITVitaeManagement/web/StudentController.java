package com.ragbecca.ITVitaeManagement.web;

import com.ragbecca.ITVitaeManagement.entity.Student;
import com.ragbecca.ITVitaeManagement.service.StudentService;
import com.ragbecca.ITVitaeManagement.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/manager/students/create")
    GenericResponse createManager(@Valid @RequestBody Student student) {
        studentService.saveStudent(student);
        return new GenericResponse("Student saved");
    }

    @GetMapping("/manager/students")
    List<Student> getAllStudents() {
        return Arrays.stream(studentService.getStudents()).collect(Collectors.toList());
    }
}
