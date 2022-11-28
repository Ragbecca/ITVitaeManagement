package com.ragbecca.ITVitaeManagement.service;

import com.ragbecca.ITVitaeManagement.entity.Student;
import com.ragbecca.ITVitaeManagement.entity.vm.StudentUpdateVM;
import com.ragbecca.ITVitaeManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student) {
        student.setPercentagePresent(100);
        studentRepository.save(student);
    }

    public Student[] getStudents() {
        return studentRepository.findAll().toArray(Student[]::new);
    }

    public Student getById(Long id) {
        return studentRepository.getReferenceById(id);
    }

    public Student update(long id, StudentUpdateVM studentUpdateVM) {
        Student inDB = studentRepository.getReferenceById(id);
        inDB.setDisplayName(studentUpdateVM.getDisplayName());
        inDB.setEmail(studentUpdateVM.getEmail());
        inDB.setInClass(studentUpdateVM.getInClass());
        return studentRepository.save(inDB);
    }
}
