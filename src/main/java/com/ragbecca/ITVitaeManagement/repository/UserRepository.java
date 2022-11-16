package com.ragbecca.ITVitaeManagement.repository;

import com.ragbecca.ITVitaeManagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Page<User> findByRole(String role, Pageable pageable);

}
