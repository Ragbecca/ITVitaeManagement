package com.ragbecca.ITVitaeManagement.service;

import com.ragbecca.ITVitaeManagement.entity.User;
import com.ragbecca.ITVitaeManagement.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Getter
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
