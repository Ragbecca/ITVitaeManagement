package com.ragbecca.ITVitaeManagement.validation;

import com.ragbecca.ITVitaeManagement.entity.User;
import com.ragbecca.ITVitaeManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User inDB = userRepository.findByUsername(value);
        return inDB == null;
    }
}
