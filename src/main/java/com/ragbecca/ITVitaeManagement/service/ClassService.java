package com.ragbecca.ITVitaeManagement.service;

import com.ragbecca.ITVitaeManagement.entity.Class;
import com.ragbecca.ITVitaeManagement.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public void saveClass(Class classDB) {
        classRepository.save(classDB);
    }

    public Class[] getClasses() {
        return classRepository.findAll().toArray(Class[]::new);
    }

    public Class getById(Long id) {
        return classRepository.getReferenceById(id);
    }
}
