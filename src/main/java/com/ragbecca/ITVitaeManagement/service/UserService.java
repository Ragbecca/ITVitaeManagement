package com.ragbecca.ITVitaeManagement.service;

import com.ragbecca.ITVitaeManagement.entity.User;
import com.ragbecca.ITVitaeManagement.entity.vm.UserUpdateVM;
import com.ragbecca.ITVitaeManagement.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Getter
    PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void saveManager(User user) {
        user.setRole("MANAGER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void saveTeacher(User user) {
        user.setRole("TEACHER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User[] getTeachers() {
        return userRepository.findByRole("TEACHER");
    }

    public User[] getManagers() {
        return userRepository.findByRole("MANAGER");
    }

    public User update(long id, UserUpdateVM userUpdate) {
        User inDB = userRepository.getReferenceById(id);
        inDB.setDisplayName(userUpdate.getDisplayName());
        inDB.setPassword(passwordEncoder.encode(userUpdate.getPassword()));
        return userRepository.save(inDB);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
