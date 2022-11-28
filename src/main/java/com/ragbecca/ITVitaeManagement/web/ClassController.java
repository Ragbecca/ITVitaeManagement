package com.ragbecca.ITVitaeManagement.web;

import com.ragbecca.ITVitaeManagement.entity.Class;
import com.ragbecca.ITVitaeManagement.entity.Days;
import com.ragbecca.ITVitaeManagement.entity.User;
import com.ragbecca.ITVitaeManagement.entity.vm.ClassVM;
import com.ragbecca.ITVitaeManagement.repository.DaysRepository;
import com.ragbecca.ITVitaeManagement.repository.UserRepository;
import com.ragbecca.ITVitaeManagement.service.ClassService;
import com.ragbecca.ITVitaeManagement.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;
    @Autowired
    private DaysRepository daysRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/manager/groups/create")
    GenericResponse createClass(@Valid @RequestBody ClassVM classVM) {
        Class classDB = new Class();
        List<Days> days = new ArrayList<>();
        for (String daysId : classVM.getDays()) {
            days.add(daysRepository.findById(Long.valueOf(daysId)).get());
        }
        List<User> teachers = new ArrayList<>();
        for (String teacherId : classVM.getTeachers()) {
            teachers.add(userRepository.findById(Long.valueOf(teacherId)).get());
        }
        classDB.setTeachers(teachers);
        classDB.setDays(days);
        classDB.setName(classVM.getName());
        classService.saveClass(classDB);
        return new GenericResponse("Group saved");
    }

    @GetMapping("/manager/groups")
    List<Class> getAllClasses() {
        return Arrays.stream(classService.getClasses()).collect(Collectors.toList());
    }
}
