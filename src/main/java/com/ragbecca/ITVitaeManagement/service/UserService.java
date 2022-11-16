package com.ragbecca.ITVitaeManagement.service;

import com.ragbecca.ITVitaeManagement.entity.User;
import com.ragbecca.ITVitaeManagement.entity.vm.UserUpdateVM;
import com.ragbecca.ITVitaeManagement.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<User> getTeachers(Pageable pageable) {
        return userRepository.findByRole("TEACHER", pageable);
    }

    public Page<User> getManagers(Pageable pageable) {
        return userRepository.findByRole("MANAGER", pageable);
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
