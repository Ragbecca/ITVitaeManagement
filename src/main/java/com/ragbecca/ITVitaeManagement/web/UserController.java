package com.ragbecca.ITVitaeManagement.web;

import com.ragbecca.ITVitaeManagement.entity.User;
import com.ragbecca.ITVitaeManagement.entity.vm.UserUpdateVM;
import com.ragbecca.ITVitaeManagement.entity.vm.UserVM;
import com.ragbecca.ITVitaeManagement.service.UserService;
import com.ragbecca.ITVitaeManagement.util.ApiError;
import com.ragbecca.ITVitaeManagement.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/manager/managers/create")
    GenericResponse createManager(@Valid @RequestBody User user) {
        userService.saveManager(user);
        return new GenericResponse("Manager saved");
    }

    @PostMapping("/manager/teachers/create")
    GenericResponse createTeacher(@Valid @RequestBody User user) {
        userService.saveTeacher(user);
        return new GenericResponse("Teacher saved");
    }

    @GetMapping("/teachers/{id}")
    void getLeraarByName(@PathVariable String id) {
        //TODO
    }

    @GetMapping("/teachers")
    List<UserVM> getAllTeachers() {
        return Arrays.stream(userService.getTeachers()).map(UserVM::new).collect(Collectors.toList());
    }

    @GetMapping("/users/{username}")
    User getUserByName(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @PutMapping("/users/{id:[0-9]+}")
    @PreAuthorize("#id == principal.id")
    User updateUser(@PathVariable long id, @Valid @RequestBody(required = false) UserUpdateVM userUpdate) {
        return userService.update(id, userUpdate);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiError handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError(404, "Validation error", request.getServletPath());

        BindingResult result = exception.getBindingResult();

        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : result.getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        apiError.setValidationErrors(validationErrors);

        return apiError;
    }
}
